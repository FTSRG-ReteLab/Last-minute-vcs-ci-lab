package hu.bme.mit.train.tachograph;



import static org.junit.Assert.assertFalse;

import java.util.Date;



import org.junit.Assert;

import org.junit.Test;

//import junit.framework.Assert;

public class TacoTableElement {

	@Test
	public void tacotastetest() {
		Tachograph table = new Tachograph();
		Date dys = new Date();
		table.addTableElement(dys, 5, 7);
		
		assertFalse(table.isEmpty());
	}

}
