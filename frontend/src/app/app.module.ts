import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { ChartDisplayComponent, ChartDataProviderService } from './chart';

@NgModule({
  declarations: [
    AppComponent,
    ChartDisplayComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],

  providers: [ChartDataProviderService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
