package util;
/*
**************************************************************************
** Realisierung des beschraenkten Puffers durch ein Array (Ringpuffer)
**  - wr: Schreibposition
**  - rd: Leseposition
*/

public class RingBuffer {
	private int[] buf;
	private int wr;
	private int rd;
	private int size;
	
	public RingBuffer(int size)
	{
		buf = new int[size];
		wr = 0;
		rd = 0;
		this.size = size;
	}
		
	public void insertItem(int item)
	{
		buf[wr] = item;
		wr = (wr + 1) % size;
	}
	
	public int removeItem()
	{
		int res = buf[rd];
		rd = (rd + 1) % size;
		return res;
	}

	public int getSize()
	{
		return size;
	}
}
