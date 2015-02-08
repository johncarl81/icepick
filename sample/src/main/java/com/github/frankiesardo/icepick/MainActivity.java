package com.github.frankiesardo.icepick;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.sample.icepick.lib.BaseActivity;
import icepick.Icicle;

public class MainActivity extends BaseActivity {

  @Icicle String message;
  @Icicle ExampleParcel exampleParcel;

  CustomView customView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    customView = (CustomView) findViewById(R.id.custom_view);
    updateText();
  }

  private void updateText() {
    String defaultText = message == null || baseMessage == null ? "Use the menu to add some state"
        : baseMessage +  message + "\n" + exampleParcel;
    customView.setText(defaultText);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  public boolean onMenuItemSelected(int featureId, MenuItem item) {
    if (item.getItemId() == R.id.action_add_state) {
      customView.setBackgroundColorWithAnotherMethod(Color.BLUE);
      customView.setTextColorWithAnotherMethod(Color.WHITE);

      baseMessage = "This state will be automagically ";
      message = "saved and restored";
      exampleParcel = new ExampleParcel("Andy", 42);
      updateText();
      return true;
    }
    return super.onMenuItemSelected(featureId, item);
  }
}
