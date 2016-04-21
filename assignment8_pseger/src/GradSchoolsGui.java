import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by philip on 4/20/16.
 * INCOMPLETE: GUI development took WAY longer than expected, so was unable to get very far.
 *              Listener below is also not impelemented.
 */
public class GradSchoolsGui extends JPanel {

    /**
     * Build our GUI objects and instances
     */
    public GradSchoolsGui() {
//        call the GridLayout constructor
        super(new GridLayout(1, 1));

//        create our grad schools object for later use
        GradSchools gs1 = new GradSchools();

//        create a jframe to begin adding stuff
        JFrame frame = new JFrame("Grad Schools");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        and create a tab object for the 3 we plan on using
        JTabbedPane tp = new JTabbedPane();

//        create the panel for about tab
        JComponent aboutPanel = new JPanel();
        JLabel label1 = new JLabel("<html><font color='white'>Choose the Grad School that fits you best!<br>" +
                "The next killer app designed by Pipanator5000 Industries.<br>" +
                "-----<br>" +
                "Select the Schools tab to add Schools. Then select the Evaluate tab to evaluate them.<br>" +
                "Good luck ranking your future life!</html>");
        aboutPanel.add(label1);
        aboutPanel.setBackground(new Color(0x2C3E50));

//        create the panel for school tab
        JComponent addSchoolPanel = new JPanel();
        addSchoolPanel.setLayout(new BoxLayout(addSchoolPanel, BoxLayout.Y_AXIS));
        JLabel label2 = new JLabel("<html><font color='white'>Fill in the information to add a school, then click \"Add School\".</html>");
        addSchoolPanel.add(label2);

        addSchoolPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel schoolName = new JLabel("School: ");
        JTextField school = new JTextField(1);
        TextInputListener schoolListener = new TextInputListener();
        addSchoolPanel.add(schoolName);
        addSchoolPanel.add(school);

        JButton button1 = new JButton("Add School");
        addSchoolPanel.add(button1);

        addSchoolPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel label3 = new JLabel("<html><font color='white'>Information on the new school will appear here.</html>");
        addSchoolPanel.add(label3);

        JPanel addSpecificSchool = new JPanel();

        addSchoolPanel.setBackground(new Color(0xE74C3C));



//        create the panel for the evaluate tab
        JComponent evaluatePanel = new JButton("Button");

//        create the three tab groups
        tp.addTab("About", aboutPanel);
        tp.addTab("Add School", addSchoolPanel);
        tp.addTab("Evaluate", evaluatePanel);

//        set the frame specifics
        frame.setPreferredSize(new Dimension(830, 230));
        frame.getContentPane().add(tp);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GradSchoolsGui gsg = new GradSchoolsGui();
    }

    private class TextInputListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String schoolName = "";

            if (event.getSource() == schoolName) {
            }
        }
    }
}
