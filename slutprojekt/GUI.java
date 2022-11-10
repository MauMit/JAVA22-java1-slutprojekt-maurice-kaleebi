//Maurice Kaleebi Java Slutprojekt

package slutprojekt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*This class creates a GUI for the calendar that contains a week, from Monday-Sunday*/

class GUI {
	/*
	 * I create 7 JPanels in a for loop and make my JFrame static so it can be read
	 * by the whole class.
	 */

	static JFrame frame = new JFrame("Slut Projekt-Calendar");

	static void guiMethod() {

		frame.setSize(1400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());

		for (int i = 1; i <= 7; i++) {

			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			JPanel panel = new JPanel();
			panel.setBorder(loweredbevel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			addGroupOfComponents(panel);
			frame.add(panel);
			frame.setVisible(true);

		}

	}

	/*
	 * 
	 * * I Create two labels, one for week name and one for day of month. I Create
	 * an if statement to check today's date and give it the color blue
	 */

	private static void addGroupOfComponents(JPanel container) {

		JLabel dayNameLabel = new JLabel(Calendar.weekDay.getDayOfWeek() + "");
		JLabel numOfMonthLabel = new JLabel(Calendar.weekDay.getDayOfMonth() + " " + Calendar.weekDay.getMonth());
		dayNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		numOfMonthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dayNameLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
		numOfMonthLabel.setFont(new Font("Sans-serif", Font.BOLD, 20));
		dayNameLabel.setForeground(Color.MAGENTA);

		if (Calendar.date.getDayOfMonth() == Calendar.weekDay.getDayOfMonth()) {
			dayNameLabel.setForeground(Color.BLUE);
			numOfMonthLabel.setForeground(Color.BLUE);
		}

		Calendar.weekDay = Calendar.weekDay.plusDays(1);

		JTextField textField = new JTextField("", 100);
		JButton addButton = new JButton("Add Event");
		JButton removeButton = new JButton("Remove Event");
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeButton.setForeground(Color.RED);

		textField.setPreferredSize(new Dimension(0, 100));
		textField.setMaximumSize(textField.getPreferredSize());

		addButtonListener(addButton, removeButton, textField, container);

		container.add(dayNameLabel);
		container.add(numOfMonthLabel);
		container.add(Box.createVerticalStrut(50));
		container.add(textField);
		container.add(Box.createVerticalStrut(10));
		container.add(addButton);
		container.add(Box.createVerticalStrut(10));
		container.add(removeButton);
	}

	/*
	 * I create an array and an if statement attached to my buttons so I can add and
	 * remove labels
	 */

	public static void addButtonListener(JButton b, JButton b2, JTextField tf, JPanel container) {
		ActionListener bListener = new ActionListener() {
			JLabel textLabel = new JLabel();

			JLabel[] labelArray = new JLabel[10];
			int list = 0;

			@Override
			public void actionPerformed(ActionEvent e) {

				Object o = e.getSource();

				if (o == b) {
					if (list < labelArray.length) {
						textLabel = new JLabel();

						textLabel.setText("* " + tf.getText());
						textLabel.setFont(new Font("Sans-serif", Font.BOLD, 15));
						textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
						labelArray[list] = textLabel;
						container.add(labelArray[list]);
						list++;
						tf.setText(null);
					}
				} else if (o == b2) {
					if (list > 0) {
						list--;
						container.remove(labelArray[list]);
						container.revalidate();
						container.repaint();
					}

				}
				frame.setVisible(true);
			}

		};
		b.addActionListener(bListener);
		b2.addActionListener(bListener);

	}

}
