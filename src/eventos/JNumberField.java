package eventos;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public final class JNumberField extends JTextField implements FocusListener{
	
	private static final long serialVersionUID = 1L;
	
	private boolean focusSelect;
	
	private double value = 0;
	
	public JNumberField(String v, int col, boolean SoF) {
		super(v, col);
		setSelectOnFocus(SoF);
		addFocusListener(this);
	}
	
	public JNumberField() {this("0", 7, false);}
	
	public JNumberField(String v) {this(v, v.length(), false);}
	
	public JNumberField(String v, int col) {this(v, col, false);}
	
	public JNumberField(int col) {this("0", col, false);}
	
	public JNumberField(boolean SoF) {this("0", 7, SoF);}
	
	public JNumberField(int col, boolean SoF) {this("0", col, SoF);}
	
	public void setSelectOnFocus(boolean b) {
		focusSelect = b;
	}
	public boolean isSelectOnFocus() {
		return focusSelect;
	}
	public void focusGained(FocusEvent e) {
		if (focusSelect) {
			super.selectAll();
		}
	}
	public double getValue() {
		if (!super.getText().equals("")) {
			if (((NumberDocument)this.getDocument()).change) {
				value = Double.parseDouble(super.getText()); 
			}
			return value;
		} else
			return 0;
	}
	public int getValueAsInt() {
		if (!super.getText().equals("")) {
			if (((NumberDocument)this.getDocument()).change) {
				value = Double.parseDouble(super.getText()); 
			}
			return (int)value;
		} else
			return 0;
	}
	public void setValue(double value) {
		setText(""+value);
	}
	public void focusLost(FocusEvent e) {}
	
	protected Document createDefaultModel() {
		return new NumberDocument();
	}
	static class NumberDocument extends PlainDocument {
		
		private static final long serialVersionUID = 1L;
		protected boolean change = false;
		public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
				String text = getText(0, this.getLength());
				if (text.equals(str)) {
					super.insertString(offset, str.trim(), a);
					return;
				}
				if (str.contains(".") && text.contains("."))
					return;
				if (str.indexOf('.') != str.lastIndexOf('.'))
					return;
				if (str.contains("-") && text.contains("-"))
					return;
				if (str.contains("+") && text.contains("+"))
					return;
			try {
				Double.parseDouble(text+str.trim());
			} catch (NumberFormatException nfe) {return;}
			change = true;
			super.insertString(offset, str.trim(), a);
		}
	}
}