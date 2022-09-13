public class Tools {
	public boolean isDigit(String letters) {

		try {
			Integer.parseInt(letters);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isBook(String s) {
		s = s.toLowerCase().trim().replace(" ", "_") + ".txt";
		//System.out.println("+<" + s + ">+");
		Bible bible = new Bible();
		for (String book : bible.books) {
			if (s.equals(book)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSpaceBook(String s) {
		Bible b = new Bible();
		for (String book : b.books) {
			book = book.replace(".txt", "");
			if (book.contains("_")) {
				if (s.contains(book.replace("_", " "))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isBookChapter(String s) {
		String str = s.toLowerCase().trim();
		//System.out.println("-<" + str + ">-");
		if (str.contains("song of solomon")) {
			str = "song_of_solomon" + str.split("song of solomon")[1];
		}
		boolean containsbook = false;
		boolean containsdigit = false;
		boolean containsspace = false;
		boolean isAligned = false;
		boolean isTwoArgs = false;
		Bible bible = new Bible();

		for (String b : bible.books) {
			if (str.contains(b.replace(".txt", ""))) {
				containsbook = true;
				//System.out.println("contains book");
			} else {

				if (isSpaceBook(str)) {

					containsbook = true;
					str = replaceFirstSpace(str);

				}
			}
		}

		for (char letter : str.toCharArray()) {
			if (isDigit(Character.toString(letter))) {
				containsdigit = true;
			}
			if (Character.toString(letter).equals(" ")) {
				containsspace = true;
			}
		}
		if (str.split(" ").length == 2) {
			isTwoArgs = true;
		}
		String[] sp = str.split(" ");

		if (sp.length == 2 && isDigit(sp[1]) && !isDigit(sp[0])) {
			isAligned = true;
		}
		if (containsdigit && containsbook && containsspace && isTwoArgs && isAligned) {
			return true;
		}
		return false;
	}

	public boolean isBookChapterVerse(String str) {
		//System.out.println("$<"+str+"$>");
		
		if (str.contains("song of solomon")) {
			str = "song_of_solomon" + str.split("song of solomon")[1];
		}
//System.out.println("$<"+str+"$>");
		Bible bible = new Bible();
		boolean isAligned = false;
		boolean containsbook = false;

		for (String book : bible.books) {
			book = book.replace(".txt", "");
			if (str.contains(book)) {
				containsbook = true;
			} else {
				if (isSpaceBook(str)) {
					containsbook = true;
					str = replaceFirstSpace(str);
				}
			}
		}
		String[] sp = str.split(" ");
		if (sp.length == 3 && isDigit(sp[2]) && isDigit(sp[1]) && !isDigit(sp[0])) {
			isAligned = true;
		}
		boolean containsspace = str.contains(" ");
		if (isAligned && containsbook && containsspace) {
			return true;
		}
		return false;
	}

	public String replaceFirstSpace(String str) {
		/*
		this function replaces the first space in str with an underscore
		*/
		String[] s = str.split(" ");

		char c = '_';
		//remember, single quotes for chars, double quotes for strings
		int charbeforespace = s[0].length();

		String result = str.substring(0, charbeforespace) + c + str.substring(charbeforespace + 1);
		return result;
	}

}