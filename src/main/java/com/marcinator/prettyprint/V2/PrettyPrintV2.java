package com.marcinator.prettyprint.V2;

import java.util.Collections;
import java.util.Set;

interface CMDAttribute {
	String getAttribute();
}

// TODO support other ansi commands
// TODO add object pretty printing
/**
 * Print utility for at prettier console experience
 */
public class PrettyPrintV2 {
	public static String RESET = "\033[0m";
	public static String PREFIX = "\033[";
	public static String POSTFIX = "m";
	public static String SEPARATOR = ";";

	private String foreground;
	private String background;

	private Set<CMDAttribute> attributes;

	private String cache;

	// region attribute helpers
	public void addAttribute(CMDAttribute attribute) {
		attributes.add(attribute);
		updateAttributeCache();
	}

	public void addAttributes(CMDAttribute... attribute) {
		Collections.addAll(attributes, attribute);
		updateAttributeCache();
	}

	public void removeAttribute(CMDAttribute attribute) {
		attributes.remove(attribute);
		updateAttributeCache();
	}

	public void removeAttributes(CMDAttribute... attribute) {
		for (CMDAttribute cmdAttribute : attribute) {
			attributes.remove(cmdAttribute);
		}
		updateAttributeCache();
	}

	private void updateAttributeCache() {
		for (CMDAttribute cmdAttribute : attributes) {
			cache += ";" + cmdAttribute.getAttribute();
		}

		if (cache.length() > 0)
			cache = cache.substring(1);
	}

	// endregion

	// region Constructors
	public PrettyPrintV2() {
	}

	public PrettyPrintV2(PrettyColor2 foreground) {
		addAttribute(new ColorAttribute(foreground));
	}

	public PrettyPrintV2(PrettyColor2 foreground, PrettyColor2 background) {
		addAttributes(
				new ColorAttribute(foreground),
				new ColorAttribute(background, true));
	}

	// endregion

	// region Setters
	private void setAttribute(CMDAttribute attribute, boolean enable) {
		if (enable) {
			addAttribute(attribute);
		} else {
			removeAttribute(attribute);
		}
	}

	public PrettyPrintV2 setBold(boolean bold) {
		setAttribute(CMDAttributes.BOLD, bold);

		return this;
	}

	public PrettyPrintV2 setUnderline(boolean underline) {
		setAttribute(CMDAttributes.UNDERLINE, underline);

		return this;
	}

	// TODO restructure following code
	public PrettyPrintV2 setForeground(PrettyColor2 foreground) {
		this.foreground = foreground != null ? "2;" + formatColor(foreground) : null;
		updateAttributeCache();

		return this;
	}

	public PrettyPrintV2 setForeground(int foreground) {
		this.foreground = ";5;" + foreground;
		updateAttributeCache();

		return this;
	}

	public PrettyPrintV2 setBackground(PrettyColor2 background) {
		this.background = background != null ? "2;" + formatColor(background) : null;
		updateAttributeCache();

		return this;
	}

	public PrettyPrintV2 setBackground(int background) {
		this.background = ";5;" + background;
		updateAttributeCache();

		return this;
	}
	// endregion

	// region printers
	public PrettyPrintV2 print(String message) {
		String tmp = PREFIX + cache + POSTFIX + message + RESET;
		System.out.print(tmp);

		return this;
	}

	public PrettyPrintV2 println(String message) {
		print(message + "\n");

		return this;
	}

	// region Service methods

	// endregion Service methods

	// endregion

	// region Formatters

	// endregion

	// region overridden

	// endregion

}
