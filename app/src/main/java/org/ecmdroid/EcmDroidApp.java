/*
 EcmDroid - Android Diagnostic Tool for Buell Motorcycles
 Copyright (C) 2019 by Michel Marti

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 3
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
package org.ecmdroid;

import android.app.Application;

import java.io.IOException;

public class EcmDroidApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.setupDB();
            // Open and close newly installed database so that the version pragma is set
            dbHelper.getReadableDatabase().close();

        } catch (IOException e) {
            throw new RuntimeException("Unable to setup database", e);
        }
    }
}
