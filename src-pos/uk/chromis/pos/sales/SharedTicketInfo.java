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

package uk.chromis.pos.sales;

import uk.chromis.basic.BasicException;
import uk.chromis.data.loader.DataRead;
import uk.chromis.data.loader.DataWrite;
import uk.chromis.data.loader.SerializableRead;
import uk.chromis.data.loader.SerializableWrite;

/**
 *
 * JG - add AppUser
 * JG - Aug 2014 Add Customer
 * Format is CustomerName : Ticket : User
 */
public class SharedTicketInfo implements SerializableRead, SerializableWrite {
    
    private static final long serialVersionUID = 7640633837719L;
    private String id;
    private String name;
    private String UserName;
    private String CustomerName;    
    
    /** Creates a new instance of SharedTicketInfo */
    public SharedTicketInfo() {
    }
    
    /**
     *
     * @param dr
     * @throws BasicException
     */
    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
        UserName = dr.getString(3);
        CustomerName = dr.getString(4);  

    }   

    /**
     *
     * @param dp
     * @throws BasicException
     */
    @Override
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, name);
        dp.setString(3, UserName);
        dp.setString(4, CustomerName);        
    }
    
    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

// JG Aug 2014 - Add User info

    /**
     *
     * @return
     */
        public String getAppUser() {
        return UserName;
    }
// JG Aug 2014 - Add Customer info

    /**
     *
     * @return
     */
        public String getCustomerName() {
        return CustomerName;
    }        
}