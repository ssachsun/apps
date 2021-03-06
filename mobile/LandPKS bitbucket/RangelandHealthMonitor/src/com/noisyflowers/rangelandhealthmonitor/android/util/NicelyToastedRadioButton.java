/**
 * 
 * Copyright 2014 Noisy Flowers LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 
 * com.noisyflowers.rangelandhealthmonitor.android.util
 * NicelyToastedRadioButton.java
 */

package com.noisyflowers.rangelandhealthmonitor.android.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class NicelyToastedRadioButton extends RadioButton {

	private Context context;	
	private static Toast toast;
	
	public static void cancelToast() {
		if (toast != null) toast.cancel();
	}

	public NicelyToastedRadioButton(Context context) {
		this(context, null);
	}

    public NicelyToastedRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
		this.context = context;
		this.setOnClickListener(rBClickListener);
		toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
    }

	private RBClickListener rBClickListener = new RBClickListener();
	private class RBClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			try {  
				String tag = (String)v.getTag();
				toast.setText(tag);
				toast.show();
			} catch (NullPointerException nPE) {} 			
		}	
	}

	
}
