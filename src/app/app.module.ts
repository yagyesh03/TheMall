import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatGridListModule } from '@angular/material/grid-list';

import { ContactUsNewComponent } from './contact-us-new/contact-us-new.component';
import { SocialComponent } from './contact-us-new/social/social.component';
import { ReachUsComponent } from './contact-us-new/reach-us/reach-us.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AnimateComponent } from './animate/animate.component';
import { DirectoryNewComponent } from './directory-new/directory-new.component';
import { HttpClientModule } from '@angular/common/http';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HeaderComponent } from './header/header.component';
import { BishtPaymentComponent } from './bisht-payment/bisht-payment.component';


@NgModule({
  declarations: [
    AppComponent,
    ContactUsNewComponent,
    SocialComponent,
    ReachUsComponent,
    AnimateComponent,
    DirectoryNewComponent,
    ContactUsComponent,
    HeaderComponent,
    BishtPaymentComponent,
  ],
  imports: [

    BrowserModule,    
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    MatGridListModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
