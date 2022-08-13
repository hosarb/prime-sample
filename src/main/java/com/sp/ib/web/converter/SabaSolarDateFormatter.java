package com.sp.ib.web.converter;


import com.sp.ib.util.DateUtil;
import com.sp.ib.util.HijriShamsiCalendar;
import org.primefaces.component.calendar.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA. User: arbaboon Date: 8/4/12 Time: 11:01 AM
 *
 * @author arbaboon & kabi
 */
public class SabaSolarDateFormatter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        try {
            java.util.Calendar calendar = new HijriShamsiCalendar();
            if (value != null && !value.isEmpty()) {
                String pattern = getPattern(component);

                if (!DateUtil.realDayAndMonthRange(value, pattern)) {
                    throw new ConverterException();
                }

                SimpleDateFormat format = new SimpleDateFormat(pattern);
                format.setCalendar(calendar);
                return format.parse(value);
            }

            return value;
        } catch (Exception ex) {
            throw new ConverterException();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

        try {
            java.util.Calendar calendar = new GregorianCalendar();
            if (context.getViewRoot().getLocale().getLanguage().equalsIgnoreCase("fa")) {
                calendar = new HijriShamsiCalendar();
            }
            if (value != null) {
                if (value instanceof Date) {
                    String pattern = getPattern(component);

                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    format.setCalendar(calendar);
                    return format.format(value);
                } else {
                    return value.toString();
                }
            }
            return "";
        } catch (Exception ex) {
            throw new ConverterException();
        }
    }

    protected String getPattern(UIComponent component) {
        if (component instanceof Calendar) {
            return ((Calendar) component).getPattern();
        }
        for (UIComponent child : component.getChildren()) {
            if (child instanceof UIParameter && "pattern".equals(((UIParameter) child).getName())) {
                return ((UIParameter) child).getValue().toString();
            }
        }
        return "yyyy/MM/dd";
    }
}
