package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class BuyResultPacket extends Packet {
	
	public static final byte ID = 16;
	
	public int result;
	public String resultString;

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.result = in.readInt();
		this.resultString = in.readUTF();
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.result);
		out.writeUTF(this.resultString);
	}

}
