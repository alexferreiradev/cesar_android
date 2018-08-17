package com.arfapps.cesar_app.util;

public final class StringUtil {

	public static boolean stringsHasTypoChanged(char[] oldWord, char[] newWord) {
		int oldSize = oldWord.length;
		int newSize = newWord.length;
		int totalTyped;
		int diff = Math.abs(newSize - oldSize);
		if (diff == 0) {
			totalTyped = calculateTotalTypedToReplace(oldWord, newWord);
		} else if (diff > 1) {
			return false;
		} else {
			totalTyped = calculateTotalTyped(oldWord, newWord);
			totalTyped = totalTyped == 0 ? 1 : totalTyped;
		}

		return totalTyped == 1;
	}

	private static int calculateTotalTypedToReplace(char[] oldWord, char[] newWord) {
		int oldSize = oldWord.length;
		int totalTyped = 0;
		for (int i = 0; i < oldSize; i++) {
			if (i >= newWord.length) {
				break;
			}

			boolean hasTyped = oldWord[i] != newWord[i];
			if (hasTyped) {
				totalTyped++;
				if (totalTyped > 1) {
					break;
				}
			}
		}

		return totalTyped;
	}

	private static int calculateTotalTyped(char[] oldWord, char[] newWord) {
		int oldSize = oldWord.length;
		int totalTyped = 0;
		int lastIndexTyped = 0;
		for (int i = 0; i < oldSize; i++) {
			if (i >= newWord.length) {
				break;
			}

			boolean hasTyped = oldWord[i] != newWord[lastIndexTyped++];
			if (hasTyped) {
				lastIndexTyped = i;
				totalTyped++;
				if (totalTyped > 1) {
					break;
				}
			}
		}

		return totalTyped;
	}

	public static boolean stringsHasPermuted(char[] from, char[] to) {
		boolean firstHasDifferent = from[0] != to[0];
		if (firstHasDifferent) {
			return false;
		}

		int totalDiff = 0;
		int stringLength = from.length;
		for (int i = 0; i < stringLength; i++) {
			if (i == to.length) {
				break;
			}

			boolean hasDifference = from[i] != to[i];
			if (hasDifference) {
				totalDiff++;
			}
		}
		if (stringLength > 3) {
			int toleranceToPermutation = (2 * stringLength) / 3;
			return totalDiff <= toleranceToPermutation;
		}

		return totalDiff > 0;
	}

	public static String replaceVectorWith(char[] original, String replacement, char characterToReplace) {
		char[] newVector = new char[original.length];
		char[] replacementChar = replacement.toCharArray();
		for (int i = 0, j = 0; j < original.length; i++) {
			boolean isToReplace = original[i] == characterToReplace;
			if (isToReplace) {
				newVector[j++] = replacementChar[0];
				for (int k = 1; k < replacementChar.length; k++) {
					newVector[j++] = replacementChar[k];
				}
			} else {
				newVector[j++] = original[i];
			}
		}

		return String.valueOf(newVector);
	}

	public static String replaceVectorLessMemoryWith(char[] original, String replacement, char characterToReplace) {
		char[] replacementChar = replacement.toCharArray();
		int replacementSize = replacement.length();
		int originalSize = original.length;
		for (int i = originalSize - 1, j = originalSize - 1; j >= 0; i--) {
			char currentChar = original[i];
			if (j == originalSize - 1) {
				if (currentChar != ' ') {
					original[j--] = currentChar;
				}
			} else {
				if (currentChar == characterToReplace) {
					// insert replace
					original[j--] = replacementChar[replacementSize - 1];
					for (int k = replacementSize - 2; k >= 0; k--) {
						original[j--] = replacementChar[k];
					}
				} else {
					original[j--] = currentChar;
				}
			}
		}

		return String.valueOf(original);
	}
}
