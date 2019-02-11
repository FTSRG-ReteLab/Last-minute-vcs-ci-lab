package hu.bme.mit.train.tachograph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TacoTableElement {

	@Test
	void tacotastetest() {
		Tachograph table = new Tachograph();
		table.addTableElement(new Date(), 5, 7);
		
		assertFalse(table.isEmpty());
	}

}
