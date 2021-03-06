package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class UnknownPacket extends Packet {
	
	private final byte id;
	private final List<Byte> bytes = new LinkedList<Byte>();
	
	public UnknownPacket(byte id) {
		this.id = id;
	}

	@Override
	public byte id() {
		return this.id;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		try {
			while (true) {
				this.bytes.add(in.readByte());
			}
		} catch (Exception e) {}
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		for (Byte b: this.bytes) {
			out.writeByte(b);
		}
	}

}
