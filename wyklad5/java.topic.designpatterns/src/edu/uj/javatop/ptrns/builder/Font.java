package edu.uj.javatop.ptrns.builder;


/**
 * Wzorzec Builder
 * Klasa Font posiada skomplikowany konstruktor. W zwiazku z tym przygotowana jest klasa wewnetrzna
 * Builder, ktora umozliwia konstruowanie obiektow Font. Konstrukcja rozbita jest na kilka
 * krokow i zakonczona wywolaniem metody build().
 * 
 * new Font("Arial", 14, true, false, true);
 * new Font("Arial", 14);
 * new Font("Arial");
 * new Font("Arial", true);
 *
 */
public class Font {
	private final String name;
	private final int size;
	private final boolean bold;
	private final boolean italic;
	private final boolean underline;
	
	private Font(String name, int size, boolean bold, boolean italic,
			boolean underline) {
		super();
		this.name = name;
		this.size = size;
		this.bold = bold;
		this.italic = italic;
		this.underline = underline;
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(name).append(" ").append(size).append("pt (");
		String sep = "";
		if (bold) {
			buf.append("bold");
			sep = " ";
		}
		if (italic) {
			buf.append(sep).append("italic");
			sep = " ";
		}
		if (underline) {
			buf.append(sep).append("underline");
		}
		buf.append(")");
		
		return buf.toString();
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	/**
	 * Wewnetrzna klasa buildera dla klasy Font.
	 * Wywolania metod tej klasy przygotowuja docelowy obiekt a metoda build() zwraca gotowy
	 * obiekt klasy Font spelniajacy zdefiniowane zalozenia.
	 */
	public static class Builder {
		private String fname = "Arial";
		private int fsize = 12;
		private boolean fbold = false;
		private boolean fitalic = false;
		private boolean funderline = false;
		
		public Font build() {
			return new Font(fname, fsize, fbold, fitalic, funderline);
		}
		
		public Builder name(String v) {
			fname = v;
			return this;
		}
		
		public Builder size(int v) {
			fsize = v;
			return this;
		}
		
		public Builder bold() {
			fbold = true;
			return this;
		}
		
		public Builder noBold() {
			fbold = false;
			return this;
		}
		
		public Builder italic() {
			fitalic = true;
			return this;
		}
		
		public Builder noItalic() {
			fitalic = false;
			return this;
		}
		
		public Builder underline() {
			funderline = true;
			return this;
		}
		
		public Builder noUnderline() {
			funderline = false;
			return this;
		}
		
	}
}
