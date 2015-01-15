/*
package com.limon.alfred.voicecommands.old.processing;

import android.app.Activity;

import com.limon.alfred.voicecommands.old.objects.CalendarQuery;
import com.limon.alfred.voicecommands.old.objects.OutputObject;
import com.nebulosa.secretarius.R;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

*/
/**
 * @author developer
 *//*

public class InputTextProcessor implements Lapsus {
    private OutputObject outputObject;
    private Activity mainActivity;

    */
/**
     *
     *//*

    public InputTextProcessor(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public OutputObject getOutputObject() {
        return outputObject;
    }

    public void setOutputObject(OutputObject outputObject) {
        this.outputObject = outputObject;
    }

    public void process(String testInputString, String language) {
        // load and form regexp
        // TODO: apply here lightweight pattern, we need to store used pattern
        // as cache
        String patternStr = loadRegExp(mainActivity.getString(R.string.calendar));

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(testInputString);

        if (matcher.find()) {
            int lapsusCode = analyseGroups(matcher);
            outputObject = new CalendarQuery(lapsusCode, 0, 0, testInputString, true);
        } else {
            outputObject = new CalendarQuery(Lapsus.CUSTOM, 0, 0, testInputString, true);
        }

        // load input patterns

        // compare

        // detect action in input

        // create output object

    }

    private int analyseGroups(Matcher matcher) {
        // type of commandPattern
        int commandType = evaluateCommand(matcher.group(1));
        int subcommandType = evaluateSubCommand(matcher.group(3));

        long from = 0;
        long to = 0;
        int lapsus = getLapsus(matcher.group(6), matcher.group(9), from, to, matcher.group(2) != null);

        return lapsus;
    }

    */
/**
     * @param group
     * @return
     *//*

    private int evaluateSubCommand(String group) {
        // TODO Auto-generated method stub
        return 0;
    }

    */
/**
     * @param group
     * @return
     *//*

    private int evaluateCommand(String group) {
        // TODO Auto-generated method stub
        return 0;
    }

    private int getLapsus(String timeCommand, String timeModifier, long from, long to, boolean fromNow) {

        int lapsusCode = -1;

        if (timeCommand.equals(getString(R.string.today))) {
            if (fromNow) lapsusCode = TODAY_FROM_NOW;
            else lapsusCode = TODAY;
        }
        if (timeCommand.equals(getString(R.string.week))) {
            if (fromNow) lapsusCode = THIS_WEEK_FROM_NOW;
            else lapsusCode = THIS_WEEK;
            ;
        }
        if (timeCommand.equals(getString(R.string.tomorrow))) lapsusCode = TOMORROW;
        if (timeCommand.equals(getString(R.string.day_after_tomorrow)))
            lapsusCode = DAY_AFTER_TOMORROW;

        if (timeCommand.equals(getString(R.string.month))) {
            if (fromNow) lapsusCode = THIS_MONTH_FROM_NOW;
            else lapsusCode = THIS_MONTH;
        }

        return lapsusCode;

    }

    private String getString(int key) {
        return mainActivity.getString(key);
    }

    */
/**
     * @param mainActivity
     * @param string
     *//*

    private String loadRegExp(String pattern) {
        String commands = getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(R.array.read), '|');
        String events = getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(
                R.array.events), '|');
        String time = getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(
                R.array.month), '|');
        String shift = getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(
                R.array.next), '|')
                + '|'
                + getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(
                R.array.past), '|');

        String all = getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(R.array.all), '|');

        time = time
                + '|'
                + getArrayStringAsDelimitedString(mainActivity.getResources().getStringArray(
                R.array.week), '|');
        time = time + '|' + mainActivity.getResources().getString(R.string.today) + '|'
                + mainActivity.getResources().getString(R.string.today) + '|'
                + mainActivity.getResources().getString(R.string.yesterday) + '|'
                + mainActivity.getResources().getString(R.string.tomorrow) + '|'
                + mainActivity.getResources().getString(R.string.month) + '|'
                + mainActivity.getResources().getString(R.string.week);

        pattern = pattern.replaceAll("_command_", commands).replaceAll("_event_", events)
                .replaceAll("_time_", time).replaceAll("_all_", all);
        pattern = pattern.replaceAll("_shift_", shift);

        return pattern;
    }

    */
/**
     * @param stringArray
     * @param string
     * @return
     *//*

    private String getArrayStringAsDelimitedString(String[] stringArray, Character delimiterChar) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < stringArray.length; i++) {

            buffer.append(stringArray[i]);
            if (i < stringArray.length - 1) {
                buffer.append(" ");
                buffer.append(delimiterChar);
            }
        }

        return buffer.toString();
    }

    */
/**
     * @param testInputString
     * @return
     *//*

    private String deleteSpecialTokens(String testInputString) {
        StringTokenizer tokenizer = new StringTokenizer(testInputString);

        String resultString = new String();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.equals("el") && !token.equals("la") && !token.equals("los")
                    && !token.equals("un")) {
                resultString = resultString + " " + token;
            }
        }

        return resultString;
    }

}
*/
