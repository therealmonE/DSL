package cecylb.dsl.translator;

import cecylb.dsl.translator.impl.TemplateProcessorImpl;
import cecylb.dsl.translator.impl.TranslatorImpl;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TranslatorTest {

    @Test
    public void test1() throws Exception {
        System.out.println("[TTr inline T E S T . . .]");
        final Translator translator = new TranslatorImpl(new LexerModule(), new ParserModule(), new TemplateProcessorImpl());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        translator.translate(
                new ByteArrayInputStream("a4, landscape; new TTr{ size: 0.5x, 0.5y; label: 1.5x, 1.5y, \"TtR #n\"; amount: 2; spacing: 4; }connections{ (TtR)Qn o- (TtR)S; } code: tikzpicture, \" \\def\\p{0} \\foreach \\min{0,...,\\N} { \\draw [*-] ($ (Tt R\\m.Qn) + (5mm,-0.8mm) $) -- ($ (Tt R\\m.Qn) + (5mm,2.9) $) -- ($ (Tt R\\m.R) + (-5mm,1.5) $) -- ($ (Tt R\\m.R) + (-5mm,0) $) --(Tt R\\m.R); \\global\\let\\p\\m}\";".getBytes()),
                byteArrayOutputStream
        );
        System.out.println(byteArrayOutputStream.toString());
    }
    @Test
    public void test2() throws Exception {
        System.out.println("[TTr T E S T . . .]");
        final Translator translator = new TranslatorImpl(new LexerModule(), new ParserModule(), new TemplateProcessorImpl());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        translator.translate(
                new ByteArrayInputStream("a4, landscape; new TTr{ size: 0.5x, 0.5y; label: 1.5x, 1.5y, \"TtR #n\"; amount: 2; spacing: 4; }connections{ (TtR)Qn o- (TtR)S; };".getBytes()),
                byteArrayOutputStream
        );
        System.out.println(byteArrayOutputStream.toString());
    }
    @Test
    public void test3() throws Exception {
        System.out.println("[DC T E S T . . .]");
        final Translator translator = new TranslatorImpl(new LexerModule(), new ParserModule(), new TemplateProcessorImpl());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        translator.translate(
                new ByteArrayInputStream("a4, landscape; new DC{ position: 100.0x, 100.0y; size: 0.5x, 0.6y; label: 1.5x, 1.5y, \"Dc #n\"; inputs:  3; amount: 2; spacing: 4; }connections{(Dc)oa -- (Dc)ia; };".getBytes()),
                byteArrayOutputStream
        );
        System.out.println(byteArrayOutputStream.toString());
    }
    @Test
    public void test4() throws Exception {
        System.out.println("[UJKTr T E S T . . .]");
        final Translator translator = new TranslatorImpl(new LexerModule(), new ParserModule(), new TemplateProcessorImpl());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        translator.translate(
                new ByteArrayInputStream("a4, landscape; new UJKTr{ size: 0.5x, 0.6y; label: 1.5x, 1.5y, \"JK #n\"; inputs:  3; amount: 2; spacing: 4; }connections{(JK)Q -- (JK)S; };".getBytes()),
                byteArrayOutputStream
        );
        System.out.println(byteArrayOutputStream.toString());
    }
    @Test
    public void test5() throws Exception {
        System.out.println("[UDVTr T E S T . . .]");
        final Translator translator = new TranslatorImpl(new LexerModule(), new ParserModule(), new TemplateProcessorImpl());
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        translator.translate(
                new ByteArrayInputStream("a4, landscape; new UDVTr{ size: 0.5x, 0.6y; label: 1.5x, 1.5y, \"DV #n\"; inputs:  3; amount: 2; spacing: 4; }connections{(DV)Q -- (DV)S; };".getBytes()),
                byteArrayOutputStream
        );
        System.out.println(byteArrayOutputStream.toString());
    }
}
