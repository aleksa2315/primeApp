package gui;

import controller.ActionManager;
import controller.ExitAction;
import controller.ReadAction;
import core.AppCore;
import tree.Implementation.SelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance;

    private AppCore appCore;
    private JToolBar toolBar;
    private JPanel desktop;
    private JScrollPane scrollPane;
    private JTable jTable;
    private ActionManager actionManager;
    private JTree jTree;
    private JTextPane jTextPane;


    public void initGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width/2;
        int screenHeight = screenSize.height/2;

        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.toolBar = new Toolbar();
        add(toolBar,BorderLayout.NORTH);

        this.desktop = new JPanel();
        this.desktop.setLayout(new BorderLayout());

        jTable = new JTable();
        jTable.setFillsViewportHeight(true);
        jTable.setRowSelectionAllowed(true);
        jTable.setColumnSelectionAllowed(false);

        jTextPane = new JTextPane();
        jTextPane.setPreferredSize(new Dimension(200,200));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, new JScrollPane(jTable));

        this.add(splitPane,BorderLayout.CENTER);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MainFrame(){}

    public static MainFrame getInstance(){
        if (instance == null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public void initTree(){
        DefaultTreeModel defaultTreeModel = appCore.loadResource();
        jTree = new JTree(defaultTreeModel);
        jTree.addTreeSelectionListener(new SelectionListener());
        scrollPane = new JScrollPane(jTree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        pack();
    }

    public void initialise(){actionManager = new ActionManager();}

    public static void setInstance(MainFrame instance) {
        MainFrame.instance = instance;
    }

    public void setTable(){
        this.jTable.setModel(appCore.getTableModel());
        this.jTable.addMouseListener(new ReadAction());
    }

    public AppCore getAppCore() {
        return appCore;
    }

    public void setAppCore(AppCore appCore) {
        this.appCore = appCore;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JPanel getDesktop() {
        return desktop;
    }

    public void setDesktop(JPanel desktop) {
        this.desktop = desktop;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public JTree getjTree() {
        return jTree;
    }

    public void setjTree(JTree jTree) {
        this.jTree = jTree;
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }

    public void setjTextPane(JTextPane jTextPane) {
        this.jTextPane = jTextPane;
    }
}























