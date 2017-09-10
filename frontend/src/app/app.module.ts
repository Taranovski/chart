import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { ChartsModule } from 'ng2-charts/ng2-charts';

import { AppComponent } from './app.component';

import { ChartDisplayComponent, ChartDataProviderService } from './chart';

@NgModule({
  declarations: [
    AppComponent,
    ChartDisplayComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ChartsModule
  ],

  providers: [ChartDataProviderService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
