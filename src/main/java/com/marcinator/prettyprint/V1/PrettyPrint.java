package com.marcinator.prettyprint.V1;

// TODO support other ansi commands
// TODO add object pretty printing
/**
 * Print utility for at prettier console experience
 */
public class PrettyPrint {
	public static String RESET = "\033[0m";
	public static String PREFIX = "\033[";
	public static String POSTFIX = "m";
	public static String SEPARATOR = ";";

	private String foreground;
	private String background;
	private boolean bold;
	private boolean underline;

	private String cache;

	// region Constructors
	public PrettyPrint(PrettyColor foreground) {
		setForeground(foreground);
	}

	public PrettyPrint(PrettyColor foreground, PrettyColor background) {
		setForeground(foreground);
		setBackground(background);
	}

	// endregion

	public PrettyPrint() {
	}

	// region Setters
	public PrettyPrint setBold(boolean bold) {
		this.bold = bold;
		updateAttributeCache();

		return this;
	}

	public PrettyPrint setUnderline(boolean underline) {
		this.underline = underline;
		updateAttributeCache();

		return this;
	}

	public PrettyPrint setForeground(PrettyColor foreground) {
		this.foreground = foreground != null ? "2;" + formatColor(foreground) : null;
		updateAttributeCache();

		return this;
	}

	public PrettyPrint setForeground(int foreground) {
		this.foreground = ";5;" + foreground;
		updateAttributeCache();

		return this;
	}

	public PrettyPrint setBackground(PrettyColor background) {
		this.background = background != null ? "2;" + formatColor(background) : null;
		updateAttributeCache();

		return this;
	}

	public PrettyPrint setBackground(int background) {
		this.background = ";5;" + background;
		updateAttributeCache();

		return this;
	}
	// endregion

	private void updateAttributeCache() {
		cache = "";
		if (foreground != null)
			cache += ";38;" + (foreground);
		if (background != null)
			cache += ";48;" + (background);
		if (bold)
			cache += ";1";
		if (underline)
			cache += ";4";

		if (cache.length() > 0)
			cache = cache.substring(1);
	}

	// region printers
	public PrettyPrint print(String message) {
		String tmp = formatModifier(cache) + message + RESET;
		System.out.print(tmp);

		return this;
	}

	public PrettyPrint println(String message) {
		print(message + "\n");

		return this;
	}
	// endregion

	// region Formatters
	private String formatColor(PrettyColor color) {
		return String.format("%s;%s;%s", color.r, color.g, color.b);
	}

	private String formatModifier(String modifiers) {
		return PREFIX + modifiers + POSTFIX;
	}

	// endregion

	// region overridden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foreground == null) ? 0 : foreground.hashCode());
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrettyPrint other = (PrettyPrint) obj;
		if (foreground == null) {
			if (other.foreground != null)
				return false;
		} else if (!foreground.equals(other.foreground))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		return true;
	}

	// endregion

}
