package dao.face.note;

import java.util.List;

import dto.note.NoteReceiverView;

public interface NoteDao {

	public List<NoteReceiverView> getManUser();

	public List<NoteReceiverView> getAccUser();

	public List<NoteReceiverView> getHrUser();

	public List<NoteReceiverView> getDevUser();

	public List<NoteReceiverView> getSalesUser();

}
