package no.dfo.whatsnewinjava.numberformats;

import lombok.extern.slf4j.Slf4j;

import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
public class MainCompactNumberFormats {

    public static void main(String ...args) {

        //public static NumberFormat getCompactNumberInstance() {
        //        return getInstance(Locale.getDefault(
        //                Locale.Category.FORMAT), NumberFormat.Style.SHORT, COMPACTSTYLE);
        //    }
        NumberFormat shortNF = NumberFormat.getCompactNumberInstance();

        //public static NumberFormat getCompactNumberInstance(Locale locale,
        //            NumberFormat.Style formatStyle) {
        //
        //        Objects.requireNonNull(locale);
        //        Objects.requireNonNull(formatStyle);
        //        return getInstance(locale, formatStyle, COMPACTSTYLE);
        //    }
        //NumberFormat shortNF = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);

        //private static NumberFormat getInstance(Locale desiredLocale, Style formatStyle, int choice)

        String short2 = shortNF.format(1000);
        log.info(short2); //1k //1.000

        short2 = shortNF.format(1_000_000); //1�mill. //1�Mio.
        log.info(short2); //1�mill

        short2 = shortNF.format(1500);
        log.info(short2); //2k //1.500

        shortNF.setMaximumFractionDigits(2);
        short2 = shortNF.format(1500);
        log.info(short2); //1,5k //1.500
    }


}
