//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) 2015 
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package uk.chromis.editor;

import uk.chromis.format.Formats;

/**
 *
 *   
 */
public class JEditorCurrency extends JEditorNumber {
    
	private static final long serialVersionUID = 5096754100573262803L;
	
	/** Creates a new instance of JEditorCurrency */
    public JEditorCurrency() {
    }
    
    /**
     *
     * @return
     */
        @Override
    protected Formats getFormat() {
        return Formats.CURRENCY;
    }

    /**
     *
     * @return
     */
        @Override
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE;
    }  
}
