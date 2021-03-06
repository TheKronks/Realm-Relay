package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;



public class New_TickPacket extends Packet {
	
	public static final byte ID = 50;
	
	public int tickId;
	public int tickTime;
	public Status[] statuses = new Status[0];

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.tickId = in.readInt();
		this.tickTime = in.readInt();
		this.statuses = new Status[in.readShort()];
		for (int i = 0; i < this.statuses.length; i++) {
			Status status = new Status();
			status.parseFromInput(in);
			this.statuses[i] = status;
		}
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.tickId);
		out.writeInt(this.tickTime);
		out.writeShort(this.statuses.length);
		for (Status status: this.statuses) {
			status.writeToOutput(out);
		}
	}

}
