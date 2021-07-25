public class printTextPerRole {
	static String printTextPerRole(String[] roles, String[] textLines) {
		StringBuilder    resultString = new StringBuilder("");

		for (int i = 0; i < roles.length ; i++) {
			resultString = resultString.append(roles[i] + ":\n");
			for (int j = 0; j < textLines.length; j++) {
				if (textLines[j].indexOf(roles[i] + ":", 0) == 0) {
					resultString = resultString.append(j + 1 + ")" + textLines[j].substring(roles[i].length() + 1) + "\n");
				}
			}
			resultString = resultString.append("\n");
		}

		String resStr = resultString.toString();
		return resStr;
	}

	public static void main(String[] args) {
		String[] roles = {
				"Gorodnichij", "Ammos Fedorovich",
				"Artemij Filippovich",
				"Luka Lukich"};
		String[] textLines = {
				"Gorodnichij: Ja priglasil vas, gospoda, s tem, chtoby soobshhit' vam preneprijatnoe izvestie: k nam edet revizor.",
				"Ammos Fedorovich: Kak revizor?",
				"Artemij Filippovich: Kak revizor?",
				"Gorodnichij: Revizor iz Peterburga, inkognito. I eshhe s sekretnym predpisan'em.",
				"Ammos Fedorovich: Vot te na!",
				"Artemij Filippovich: Vot ne bylo zaboty, tak podaj!",
				"Luka Lukich: Gospodi bozhe! eshhe i s sekretnym predpisan'em!"};

		String answer = printTextPerRole(roles, textLines);
		System.out.println(answer);
	}
}
