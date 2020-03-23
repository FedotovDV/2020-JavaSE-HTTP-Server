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
	void replaceChars(Reader in, Writer out, String inChars, String outChars)
			throws NullPointerException, IllegalArgumentException, IOException;

	/*
	 * Копирование стороки из входного потока в выходной, попутно заменяя символы
	 * которые есть в inChars, на символы которые находятся в той же позиции в
	 * outChars. Строки inChars и outChars должны быть одинаковой длинны. Если
	 * inChars или outChars == null считаем что на вход была подана пустая строка.
	 * Пример: in = 1234567890 inChars = 357 outChars = 480 out = 1244860890. Потоки
	 * после работы закрыть! NullPointerException - если любой из параметров in или
	 * out == null IllegalArgumentException - если inChars.length != outChars.length
	 * IOException - если при работе с потоками произошла ошибка
	 */
	List<Path> findText(Path rootDir, String textToFind, boolean ignoreCase)
			throws NullPointerException, IllegalArgumentException, IOException;
	/*
	 * Ищет файлы в которых есть вхождение строки textToFind с учетом регистра
	 * ignoreCase=false или без регистра ignoreCase=true NullPointerException - если
	 * любой из параметров rootDir или textToFind == null. IllegalArgumentException
	 * - если rootDir - не директория. IOException - если При работе с потоками
	 * произошла ошибка
	 */

}