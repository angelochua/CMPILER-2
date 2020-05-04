package driver;

import antlr4.BLexer;
import antlr4.BParser;
import interpreter.FunctionVisitor;
import interpreter.TheVisitor;
import interpreter.Function;
import model.Scope;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

import static org.antlr.v4.runtime.CharStreams.fromString;

public class B extends JFrame {

    private JPanel cp;
    private static TextArea outputArea;
    private static ArrayList<String> errors;

    private B() {
        cp = new JPanel();
        cp.setLayout(null);

        JPanel codePanel = new JPanel(new BorderLayout());

        AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory)TokenMakerFactory.getDefaultInstance();
        atmf.putMapping("text/B", "driver.TokenMaker");

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle("text/B");
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        codePanel.add(sp);

        codePanel.setSize(700, 500);

        CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(textArea);

        RSyntaxTextArea.setTemplatesEnabled(true);
        CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();

        CodeTemplate ct = new StaticCodeTemplate("br", "brint(", null);
        ctm.addTemplate(ct);

        ct = new StaticCodeTemplate("bn", "bnput(", null);
        ctm.addTemplate(ct);

        ct = new StaticCodeTemplate("bor", "bor i=0 bto ", "{\n\t\n}\n");
        ctm.addTemplate(ct);

        ct = new StaticCodeTemplate("bdo", "bdo { \n\n } bhile (", ")\n");
        ctm.addTemplate(ct);

        ct = new StaticCodeTemplate("bhile", "bhile (", ") {\n\t\n}\n");
        ctm.addTemplate(ct);

        codePanel.setLocation(20,20);
        cp.add(codePanel);

        outputArea = new TextArea();
        outputArea.setSize(950, 200);

        cp.add(outputArea);
        outputArea.setLocation(20, 550);

       // ImageIcon imageIcon = new ImageIcon(B.class.getResource("../images/rice.png"));
        //Image image = imageIcon.getImage();
        //image = image.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
       //imageIcon = new ImageIcon(image);

        //JLabel logo = new JLabel(imageIcon);
        //logo.setSize(75, 75);

        //cp.add(logo);
        //logo.setLocation(750, 20);

        Label label = new Label("Bokal");
        label.setSize(150,50);
        label.setFont(new Font("Verdana", Font.BOLD, 40));

        cp.add(label);
        label.setLocation(850, 35);

        //imageIcon = new ImageIcon(B.class.getResource("../images/xchan.png"));
        //image = imageIcon.getImage();
       // image = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
       // imageIcon = new ImageIcon(image);

       // JLabel icon1 = new JLabel(imageIcon);
        //icon1.setSize(75, 75);

        //cp.add(icon1);
        //icon1.setLocation(730, 100);


        //imageIcon = new ImageIcon(B.class.getResource("../images/don.png"));
       // image = imageIcon.getImage();
       // image = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        //imageIcon = new ImageIcon(image);

       // JLabel icon2 = new JLabel(imageIcon);
        //icon2.setSize(75, 75);

        //cp.add(icon2);
        //icon2.setLocation(730, 170);

        JLabel name2 = new JLabel("Dominic Chan");
        name2.setSize(200,75);
        name2.setFont(new Font("Verdana", Font.PLAIN, 16));

        cp.add(name2);
        name2.setLocation(810, 175);

        //imageIcon = new ImageIcon(B.class.getResource("../images/ivan.png"));
        //image = imageIcon.getImage();
        //image = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        //imageIcon = new ImageIcon(image);

        //JLabel icon3 = new JLabel(imageIcon);
        //icon3.setSize(75, 75);

        //cp.add(icon3);
        //icon3.setLocation(730, 240);

        JLabel name3 = new JLabel("Angelo Chua");
        name3.setSize(200,75);
        name3.setFont(new Font("Verdana", Font.PLAIN, 16));

        cp.add(name3);
        name3.setLocation(810, 245);

        //imageIcon = new ImageIcon(B.class.getResource("../images/rhei.png"));
        //image = imageIcon.getImage();
        //image = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        //imageIcon = new ImageIcon(image);

        //JLabel icon4 = new JLabel(imageIcon);
        //icon4.setSize(75, 75);

        //cp.add(icon4);
       // icon4.setLocation(730, 310);

        JLabel name4 = new JLabel("Emmanuel Ramin");
        name4.setSize(200,75);
        name4.setFont(new Font("Verdana", Font.PLAIN, 16));

        cp.add(name4);
        name4.setLocation(810, 310);

        JButton runButton = new JButton("Run");
        runButton.setSize(220, 50);
        runButton.addActionListener(e -> {
            perform(textArea.getText());
        });

        cp.add(runButton);
        runButton.setLocation(750, 400);

        JButton manualButton = new JButton("B User Manual");
        manualButton.setSize(220, 50);
        manualButton.addActionListener(e -> {
            openManual();
        });

        cp.add(manualButton);
        manualButton.setLocation(750, 470);

        setContentPane(cp);
        pack();
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        errors = new ArrayList<>();
        SwingUtilities.invokeLater(() -> {
            try {
                String laf = UIManager.getSystemLookAndFeelClassName();
                UIManager.setLookAndFeel(laf);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new B().setVisible(true);
        });
    }

    private static void perform(String code)  {
        outputArea.setText("");
        errors.clear();

        BLexer lexer = new BLexer(fromString(code));
        BParser parser = new BParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.source();
        Scope scope = new Scope();
        HashMap<String, Function> functions = new HashMap<>();

        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);

        ErrorVisitor errorVisitor = new ErrorVisitor();
        errorVisitor.visit(tree);

        if(errors.size() > 0) {
            for(String error : errors)
                outputArea.append(error + "\n");
        } else {
            FunctionVisitor functionVisitor = new FunctionVisitor(functions);
            functionVisitor.visit(tree);
            TheVisitor theVisitor = new TheVisitor(scope, functions);
            theVisitor.visit(tree);
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.open();
        }
    }

    private static void openManual() {
        JFrame manualFrame = new JFrame("B User Manual");
        JPanel manualPanel = new JPanel(null);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setSize(300, 410);

        manualPanel.add(textArea);
        textArea.setLocation(350, 30);

        JButton variableDeclaration = new JButton("Variable Declarations");
        variableDeclaration.setSize(250,50);

        variableDeclaration.addActionListener(e -> {
            textArea.append("There are no data types in the grammar B.\n" +
                            "It is similar to the Python language\n\n" +
                            "Normal Variables\n" +
                            "Syntax: bar *identifier* = ...\n\n" +
                            "Constant Variables\n" +
                            "Syntax: bonst bar *identifier* = ...");
        });

        manualPanel.add(variableDeclaration);
        variableDeclaration.setLocation(50, 30);

        JButton inputOrOutput = new JButton("Input/ Output Statements");
        inputOrOutput.setSize(250, 50);
        inputOrOutput.addActionListener(e -> {

            textArea.setText("1. Input \n" +
                            "Syntax: bar a = bnput();\n" +
                            "2. Output \n" +
                            "Syntax: brint(identifier or string);");
        });

        manualPanel.add(inputOrOutput);
        inputOrOutput.setLocation(50, 90);

        JButton conditional = new JButton("Conditional Statements");
        conditional.setSize(250, 50);
        conditional.addActionListener(e -> {
           textArea.setText("B supports the use of nested ifs and if else if statements\n" +
                   "Syntax: bf(condition) { \n *statements* \n } bf blse(condition) {\n *statements* \n} \n blse {*statements*}");
        });

        manualPanel.add(conditional);
        conditional.setLocation(50, 150);

        JButton loop = new JButton("Loops");
        loop.setSize(250, 50);
        loop.addActionListener(e -> {
            textArea.setText("This language supports three loops: \n\n" +
                             "1. For loop \n" +
                             "Syntax: bor i = 0 bto { \n *insert statements * \n}\n\n" +
                             "2. Do While loop \n" +
                             "Syntax: bdo { \n *insert statements * \n} bhile(condition)\n\n" +
                             "3. While loop \n" +
                             "Syntax: bhile(condition) { \n *insert statements * \n}");
        });

        manualPanel.add(loop);
        loop.setLocation(50, 210);

        JButton functions = new JButton("Functions");
        functions.setSize(250, 50);
        functions.addActionListener(e -> {
            textArea.setText("Syntax: bunc functionName(parameters) {\n " +
                             "*statements* \n +" +
                             " beturn (expression) \n } ");
        });

        manualPanel.add(functions);
        functions.setLocation(50, 270);

        JButton keywords = new JButton("Keywords");
        keywords.setSize(250, 50);
        keywords.addActionListener(e -> {
            textArea.setText("MAIN: \t 'bain'\n" +
                             "PRINT: \t 'brint' \n" +
                             "INPUT: \t 'bnput' \n" +
                             "FUNC: \t 'bunc' \n" +
                             "CONST: \t 'bonst' \n" +
                             "IF: \t 'bf' \n " +
                             "ELSE: \t 'blse' \n " +
                             "RETURN: \t 'beturn' \n " +
                             "FOR: \t 'bor' \n " +
                             "WHILE: \t 'bhile' \n " +
                             "DO: \t 'bdo' \n " +
                             "NULL: \t 'bull' \n " +
                             "VAR: \t 'bar' \n ");
        });

        manualPanel.add(keywords);
        keywords.setLocation(50, 330);

        JButton codeShortcuts = new JButton("Code Shortcuts");
        codeShortcuts.setSize(250, 50);

        manualPanel.add(codeShortcuts);
        codeShortcuts.setLocation(50, 390);
        codeShortcuts.addActionListener(e -> {
            textArea.setText("There are a few helpful features in this IDE: \n\n" +
                             "1. Code Templates \n" +
                             "-Type the keywords written below and press Ctrl+Shift+Space to generate code templates \n" +
                             "a.br \n" +
                             "- Shortcut for a print statement. Generates 'brint('\n" +
                             "b.bn \n" +
                             "- Shortcut for an input statement. Generates 'bnput('\n" +
                             "c.bor \n" +
                             "- Shortcut for a for loop. Generates 'bork(bar i = 0; i < ; i++ { \n\n }'\n" +
                             "d.bdo \n" +
                             "- Shortcut for a do while loop. Generates 'bdo { \n\n } bhile()'\n" +
                             "e.bhile \n" +
                             "- Shortcut for a while loop. Generates 'bhile() { \n \n}'");
        });

        manualFrame.setContentPane(manualPanel);
        manualFrame.pack();
        manualFrame.setSize(700, 500);
        manualFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        manualFrame.setLocationRelativeTo(null);
        manualFrame.setVisible(true);
    }

    private static CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        provider.addCompletion(new BasicCompletion(provider, "brint"));
        provider.addCompletion(new BasicCompletion(provider, "bnput"));
        provider.addCompletion(new BasicCompletion(provider, "state"));
        provider.addCompletion(new BasicCompletion(provider, "bonst"));
        provider.addCompletion(new BasicCompletion(provider, "bf"));
        provider.addCompletion(new BasicCompletion(provider, "blse"));
        provider.addCompletion(new BasicCompletion(provider, "beturn"));
        provider.addCompletion(new BasicCompletion(provider, "bor"));
        provider.addCompletion(new BasicCompletion(provider, "bhile"));
        provider.addCompletion(new BasicCompletion(provider, "bto"));
        provider.addCompletion(new BasicCompletion(provider, "bdo"));
        provider.addCompletion(new BasicCompletion(provider, "bnd"));
        provider.addCompletion(new BasicCompletion(provider, "bn"));
        provider.addCompletion(new BasicCompletion(provider, "bull"));
        provider.addCompletion(new BasicCompletion(provider, "bar"));

        return provider;

    }

    public static void appendOutput(String output) {
        outputArea.append(output + "\n");
    }

    public static String getInput() {
        final String[] result = {""};

        JFrame f = new JFrame("Input");
        return JOptionPane.showInputDialog(f, "Enter Input");
    }

    static void addErrors(String error) {
        errors.add(error);
    }
}
