/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.flexdock.plaf.resources;

import javax.swing.plaf.ColorUIResource;



import org.flexdock.plaf.Configurator;

/**
 * @author Christopher Butler
 */
public class ColorResourceHandler extends ResourceHandler {

    @Override
    public Object getResource(String stringValue) {
        return parseHexColor(stringValue);
    }

    public static ColorUIResource parseHexColor(String hexColor) {
        if(Configurator.isNull(hexColor)) {
            return null;
        }

        StringBuffer sb = new StringBuffer(6);
        int len = hexColor.length();

        // strip out non-hex characters
        for(int i=0; i<len; i++) {
            char c = hexColor.charAt(i);
            if(isHex(c)) {
                sb.append(c);
            }
        }

        try {
            int color = Integer.parseInt(sb.toString(), 16);
            return new ColorUIResource(color);
        } catch(NumberFormatException e) {
            System.err.println("Exception: " +e.getMessage());
            return null;
        }
    }

    private static boolean isHex(char c) {
        return c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' ||
               c=='9' || c=='0' || c=='A' || c=='B' || c=='C' || c=='D' || c=='E' || c=='F' ||
               c=='a' || c=='b' || c=='c' || c=='d' || c=='e' || c=='f';
    }
}
