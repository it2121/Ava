package ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Timer;

public class methodes {

	public static void main(String[] args) {

		String[] sarray = sintoarray("what is your fav movie");

		int[] iarray = getstype(sarray);
		int re = getreTypeFword(sarray[0]);
		int[] result = respondform(re, iarray);

		String[] array = endline(result, sarray);

		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);
		}

	}

	public static void opining(String[] sar) {

		for (int i = 0; i < sar.length; i++) {
			// integer[i] = getTypeFword(sar[i]);

		}

	}

	public static String[] endline(int[] form, String[] s) {

		String[] sen = new String[form.length];
		int j = 0;
		for (int i = 3; i < s.length; i++) {
			j++;
		}
		String[] pp = new String[j];
		for (int i = 3; i < s.length; i++) {
			pp[i - 3] = s[i];

		}

		String ans = getmyinfo(intostring(pp));
		int k = 0;
		if (form[0] == 0 && form[1] == 2 && form[2] == 3 && form[3] == 11) {

			if (s[2].equals("your")) {
				sen[k] = "my";
				k++;
				// ans = pp;
			} else if (s[2].equals("his")) {
				sen[k] = "his";
				k++;
			} else if (s[2].equals("her")) {
				sen[k] = "her";
				k++;
			}
			if (form[1] == 2) {
				for (int i = 3; i < s.length; i++) {

					sen[k] = s[i];
					k++;
				}
			}

			if (form[2] == 3) {
				sen[k] = s[1];
				k++;
			}

			sen[k] = ans;

		}
		return sen;

	}

	public static int[] getstype(String[] as) {
		int[] integer = new int[as.length];

		for (int i = 0; i < as.length; i++) {
			integer[i] = getTypeFword(as[i]);

		}
		for (int i = 0; i < integer.length; i++) {
			// System.out.println(integer[i]);
		}
		return integer;

	}

	public static String[] sintoarray(String a) {
		// String a = "i am the gode here.";
		int arrayl = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				arrayl++;
			}

		}
		String[] ase = new String[arrayl + 1];
		for (int i = 0; i < ase.length; i++) {
			ase[i] = "";
		}

		// String word = "";
		int arrayp = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				arrayp++;
			} else if (a.charAt(i) != ' ' && a.charAt(i) != '.') {

				ase[arrayp] += a.charAt(i);
			} else if (a.charAt(i) == '.') {
				break;
			}
		}
		return ase;

		// System.out.println(ase[4]);
	}

	public static String intostring(String[] j) {
		String ass = "";
		for (int i = 0; i < j.length; i++) {

			if (j.length - i > 1) {

				ass += j[i] + " ";
			} else {
				ass += j[i] + " ";
			}

		}

		return ass;

	}

	public static int[] respondform(int type, int[] array) {
		int[] res = new int[array.length];
		switch (type) {
		case 0:
			res[0] = 10;
			res[1] = 0;
			res[2] = 3;
			// return res;
			break;
		case 1:
			if (array[1] == 3 && array[2] == 5) {
				res[0] = 0;
				res[1] = 2;
				res[2] = 3;
				res[3] = 11;

			} else if (array[1] == 3 && array[2] == 0) {
				res[0] = 0;
				res[1] = 3;
				res[2] = 1;
				res[3] = 12;
				// return res;
			}
			break;
		case 2:
			// return res;
			break;
		case 3:
			// return res;
			break;
		// return res;
		default:
			// return res;
			break;
		}
		return res;

	}

	public static String getmyinfo(String text) {
		String type;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ai", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from info  WHERE type = '" + text
							+ "'");

			while (rs.next()) {
				type = rs.getString("ans");
				// a = rs.getInt("level");
				return type;
			}
			con.close();

		} catch (Exception e) {
			return null;

		}
		return null;
	}

	// getting the type of word
	public static int getTypeFword(String text) {
		int type;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ai", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from words  WHERE word = '" + text
							+ "'");

			while (rs.next()) {
				type = rs.getInt("typeofword");
				// a = rs.getInt("level");
				return type;
			}
			con.close();

		} catch (Exception e) {
			return 00;

		}
		return 00;
	}

	// getting the type of the replay to the word
	public static int getreTypeFword(String text) {
		int type;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ai", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from words  WHERE word = '" + text
							+ "'");

			while (rs.next()) {
				type = rs.getInt("re-type");
				// a = rs.getInt("level");
				return type;
			}
			con.close();

		} catch (Exception e) {
			return 00;

		}
		return 00;
	}

	public static void convertintoMz(String text) {
		// String a = "mohammed";
		int textl = text.length();
		char[] le = new char[25];
		le[0] = 'a';
		le[1] = 'b';
		le[2] = 'c';
		le[3] = 'd';
		le[4] = 'e';
		le[5] = 'f';
		le[6] = 'g';
		le[7] = 'h';
		le[8] = 'i';
		le[9] = 'j';
		le[10] = 'k';
		le[11] = 'l';
		le[12] = 'm';
		le[13] = 'n';
		le[14] = 'o';
		le[15] = 'p';
		le[16] = 'q';
		le[17] = 'r';
		le[18] = 's';
		le[19] = 't';
		le[20] = 'u';
		le[21] = 'v';
		le[22] = 'w';
		le[23] = 'x';
		le[24] = 'z';
		int[] intarray = new int[textl];

		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < le.length; j++) {

				if (le[j] == text.charAt(i)) {
					intarray[i] = j;

					break;
				}
			}
		}
		String full = "";
		int t;
		for (int i = 0; i < intarray.length; i++) {
			// System.out.println(intarray[i]);
			t = intarray[i];
			if (intarray.length - i > 1) {

				full += t + "-";
			} else {
				full += t;
			}
		}

	}

	public static void showtext(String atext) {
		text = atext;
		timer.start();

	}

	public static int c = 0;
	static ActionListener liss = new taaa();
	public static String a = "";
	public static String text;
	public static String first = "true";
	public static boolean buttshown = false;
	static Timer timer = new Timer(25, liss);

	public static void reset() {
		c = 0;
		a = "";
		text = null;
	}

}

class taaa implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (

		methodes.c < methodes.text.length()) {

			homw.lblNewLabel.setText(methodes.a);
			methodes.a += (methodes.text.charAt(methodes.c));
			homw.lblNewLabel.setText(methodes.a);
			methodes.c++;
		}
		if (methodes.c > methodes.text.length()) {
			methodes.timer.stop();
			methodes.c = 0;
			methodes.a = "";
			methodes.text = null;
		}

	}

}
