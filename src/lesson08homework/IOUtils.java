package lesson08homework;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface IOUtils {
	/*
	����������� ������� �� �������� ������ � ��������, ������� ������� ������� ��
	������� ���� � inChars, �� ������� ������� ��������� � ��� �� ������� � outChars.
	������ inChars � outChars ������ ���� ���������� ������. ���� inChars ��� outChars ==
	null ������� ��� �� ���� ���� ������ ������ ������. ������: in = 1234567890 inChars =
	357 outChars = 480 out = 1244860890. ������ ����� ������ �������!
	NullPointerException - ���� ����� �� ���������� in ��� out == null
	IllegalArgumentException - ���� inChars.length != outChars.length
	IOException - ���� ��� ������ � �������� ��������� ������
	*/
	void replaceChars(Reader in, Writer out, String inChars, String outChars)
			throws NullPointerException, IllegalArgumentException, IOException;
	/*���� ����� � ������� ���� ��������� ������ textToFind � ������ �������� ignoreCase=false
	��� ��� �������� ignoreCase=true
	NullPointerException - ���� ����� �� ���������� rootDir ��� textToFind == null.
	IllegalArgumentException - ���� rootDir - �� ����������.
	IOException - ���� ��� ������ � �������� ��������� ������
	*/
	List<Path> findText(Path rootDir, String textToFind, boolean ignoreCase)
			throws NullPointerException, IllegalArgumentException, IOException;
}