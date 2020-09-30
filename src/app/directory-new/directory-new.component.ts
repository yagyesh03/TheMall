import { Component, OnInit } from '@angular/core';
import { trigger,style,transition,animate,keyframes,query,stagger, state, animation } from '@angular/animations';
import { DirectoryService } from 'src/app/services/directoryService/directory.service';
import AOS from 'aos';
import 'aos/dist/aos.css';

@Component({
  selector: 'app-directory-new',
  templateUrl: './directory-new.component.html',
  styleUrls: ['./directory-new.component.css'],
  animations: [
    trigger('listAnimation', [
      transition('* => *', [

        query(':enter', style({opacity: 0, transform: 'translateY(-4500px)',clipPath: 'polygon(50% 0%, 61% 35%, 98% 35%, 68% 57%, 79% 91%, 50% 70%, 21% 91%, 32% 57%, 2% 35%, 39% 35%)'}), {optional: true}),
        query(':enter', stagger('300ms', [
          animate('5s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(-1000px),', offset: 0.8,clipPath: 'polygon(50% 0%, 61% 35%, 98% 35%, 68% 57%, 79% 91%, 50% 70%, 21% 91%, 32% 57%, 2% 35%, 39% 35%)'}),
            style({opacity: 1, transform: 'translateY(0)',     offset: 1.0}),
          ]))]), {optional: true}),

        query(':leave', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(0)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: 0.3}),
            style({opacity: 0, transform: 'translateY(-75%)', offset: 1.0}),
          ]))]), {optional: true}),
        
      ])
    ]),

    
    trigger('hoverAnimation', [
      state('postHover', style({
        transform: 'scale(1.4)',
        boxShadow: '2px 2px 15px 10px black',
      })),
      
      
      transition('postHover => *', animate(500, keyframes([
        style({transform: 'rotate(2deg) scaleX(1.09) scaleY(1.09) scaleZ(1.09)', offset:0,boxShadow: '1.5px 1.8px 18px 8px black', }),
        style({transform: 'rotate(-2deg) scaleX(1.07) scaleY(1.07) scaleZ(1.07)', offset:0.2, boxShadow: '1.3px 1.3px 15px 7px gray' }),
        style({transform: 'rotate(2deg) scaleX(1.05) scaleY(1.05) scaleZ(1.05)', offset:0.4 ,boxShadow: '1px 0.9px 12px 6px gray' }),
        style({transform: 'rotate(-2deg) scaleX(1.03) scaleY(1.03) scaleZ(1.03)', offset:0.8 ,boxShadow: '0.7px 0.5px 8px 4px white' }),
        style({transform: 'rotate(2deg) scaleX(1.01) scaleY(1.01) scaleZ(1.01)', offset:1 , }),
      ]))),

    transition('* => postHover', animate('1500ms ease-in'))
    ]),
  ]
})
export class DirectoryNewComponent implements OnInit {
  
  constructor(private dirService: DirectoryService){ 

    AOS.init();



  }

  ngOnInit(): void {

    this.dirService.getShops().subscribe(i => {

      this.brands = i
      this.carouselSelection()  
      this.topShopSelection()

    })


    AOS.init();

  }

  // VARIABLES:

  brandIndex = -1;
  brandHoverState: String;
  numberOfBrands = 8
  brandEntryState: string;
  showBrandAnimation: boolean;
  brands = new Array();
  carouselBrands = new Array();
  topBrands = new Array();

// FUNCTIONS:

  scrollOnClick(){
    document.querySelector(".test").scrollIntoView();
    this.brandEntryState = 'two'
    this.showBrandAnimation = true
  }

  loadMoreBrands(){
    this.numberOfBrands = this.numberOfBrands + 4
  }

  changeState(stateNew: String, brandIndex: number){
    this.brandHoverState = stateNew;
    this.brandIndex = brandIndex;
  }

  carouselSelection(){
    for( var j =0; j < this.brands.length; j++){
      if(this.brands[j].carousel){
        this.carouselBrands.push(this.brands[j])
      }
    }
  }

  topShopSelection(){
    for(var i = 0 ; i < 10 ; i++){
      this.topBrands.push(this.brands[Math.floor(Math.random() * 1000) % this.brands.length])
    }
    console.log(this.topBrands)
  }

}