import { Component, OnInit, HostBinding } from '@angular/core';
import {trigger,state,style,animate,transition,query,stagger, keyframes, group} from '@angular/animations';
// import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  animations:[
    trigger('expansion',[
       state('flip', style({
        transform: 'rotateY(40deg)',
        'box-shadow':'2px 2px 16px 8px rgba(255, 255, 255, 0.700)'
      })),
      state('fade-right', style({
        transform: 'translateX(170px)',
        opacity:0
      })),
    transition('* <=> flip', animate(1000)),
    transition('fade-right => *', animate(1000)),
    transition('* => fade-up', [
      group([
        animate(0, style({
          transform: 'translateY(70px)',
          opacity: 0
        })),
        animate(1000, style({
          transform: 'translateY(0px)',
          opacity: 1
        }))
      ])
    ]),
    transition('* => expand',[
      query('img,h3',style({opacity:0,transform:'translateY(-30px)'}),{optional:true}),
      query('img,h3',stagger('500ms',[
        animate('400ms',style({opacity:1,transform:'translateY(0px)'}))
      ]),{optional:true})
    ]),
    transition('* => slide', [
      animate(800, keyframes([
        style({
          transform: 'translateY(70px)',
          opacity: 0.2,
          offset: 0
        }),
        style({
          transform: 'translateY(40px)',
          opacity: 0.5,
          offset: 0.5
        }),
        style({
          transform: 'translateY(0px)',
          opacity: 1,
          offset: 1
        })
      ]))
    ]),

    ])
  ]
})
export class HeaderComponent implements OnInit {

  state1:string="normal";
  state2:string="fade-right";
  display:string="nope";
  aIndex=-1;

  
  entertainment=[{
    imageURL:"https://imgstaticcontent.lbb.in/lbbnew/wp-content/uploads/sites/1/2018/04/23151028/190418_Skating_05.jpg",
    title:"Ice SKating"
  },
  {
    imageURL:"https://i0.wp.com/mnacritique.mergersindia.com/wp-content/uploads/2016/05/pvr-strengthens-position-dt-cinemas.jpeg?fit=1200%2C675&ssl=1",
    title:"PVR"
  },
  {
    imageURL:"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/56/c0/82/smaaash-1.jpg?w=1000&h=-1&s=1",
    title:"Smash"
  },
  {
    imageURL:"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/70/98/31/fun-city-neon-signage.jpg?w=1000&h=-1&s=1",
    title:"FunCity"
  },
  {
    imageURL:"https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1295,h_971,f_auto/w_80,x_15,y_15,g_south_west,l_klook_water/activities/gxa4fnf0f2hmkgszarft/HysteriaHauntedAttractionTicketinDubai.webp",
    title:"Hysteria"
  },
  {
    imageURL:"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/56/c0/82/smaaash-1.jpg?w=1000&h=-1&s=1",
    title:"Smash"
  },
  {
    imageURL:"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/70/98/31/fun-city-neon-signage.jpg?w=1000&h=-1&s=1",
    title:"FunCity"
  },
  {
    imageURL:"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/56/c0/82/smaaash-1.jpg?w=1000&h=-1&s=1",
    title:"Smash"
  }
 ];


 featuredCategories=["Electronics","Fashion - Children","Beauty & Fragrances","Fashion - Men",
  "Fashion - Women","Home Furnishing"," New Stores at The Dubai Mall","Toys"];
  
  brands=["  Birkenstock","Bvlgari","Cartier","Chloé","Chopard Boutique","Christian Louboutin"
,"La Perla","Level Shoes","Louis Vuitton","Roberto Cavalli","Symphony"];

  occasions=["  Anniversary","Back to School","Birthday","Eid","Festive Season","Gifts for Her",
"Gifts for Him","Travel","Souvenirs","Housewarming","Wedding"];

 topPicks=[" Angelina","Big Smoke Burger","Eataly","Eat Greek","Galeries Lafayette Le Gourmet",
"Magnolia Bakery","Markette","Nando's","Social House","The Cheesecake Factory"];

cuisines=["American Cuisine","Bakery","British Food","Chinese","Fast Food","French","Indian Food",
"Italian","Japanese","Middle Eastern Food"];

wardrobe=["https://cdn.imgbin.com/13/18/21/imgbin-tuxedo-suit-t-shirt-clothing-mens-only-sons-suit-9X9XcLk8kF1rLUYRcCX2xUrkt.jpg",
"http://sc01.alicdn.com/kf/HTB1lEjUJVXXXXceXXXXq6xXFXXXM.jpg",
"https://cdn11.bigcommerce.com/s-pkla4xn3/images/stencil/1280x1280/products/4905/39825/2018-fashion-casual-clothing-social-fitness-bodybuilding-striped-t-shirts-men-t-shirt-jersey-tee-shirt__26106.1523707782.jpg?c=2?imbypass=on",
"https://i.pinimg.com/236x/6e/0c/04/6e0c049da0d6d508b6494cabf9953f34.jpg",
"https://cdn11.bigcommerce.com/s-pkla4xn3/images/stencil/1280x1280/products/27513/255399/2019-Summer-New-Men-s-Short-Ripped-Jeans-Fashion-Casual-High-Quality-Retro-Elastic-Denim-Shorts__37930.1553320853.jpg?c=2?imbypass=on",
"https://i2.wp.com/stylebeez.com/wp-content/uploads/2018/12/ROMWE-Pink-Knot-Side-Criss-Cross-Back-Sweater-Women-Clothing-2018-Autumn-Fashion-Casual-Plain-Clothes.jpg?fit=800%2C800&ssl=1",
"https://d2fzf9bbqh0om5.cloudfront.net/images/12553/original/mens-clothing.png?1564863637",
"//cdn.shopify.com/s/files/1/2615/3606/products/2019-hot-new-style-fashion-brand-men-s-casual-11-degree-printing-hoodie-men-s-2.jpg_640x640_d7714949-8f46-4ad2-a5f0-b0e05758db16_1024x1024@2x.jpg?v=1576562330",
"https://cdn11.bigcommerce.com/s-1js1zluvaj/images/stencil/1280x1280/products/40001/137408/2019-New-style-Autumn-Hooded-Denim-Jacket-Men-Fashion-Fake-Two-Pieces-Streetwear-Bomber-Jacket-and__46121.1563339557.jpg?c=2",
"https://img-static.tradesy.com/item/22654306/sunflowers-print-random-lace-up-back-a-line-cami-short-casual-dress-size-4-s-0-1-960-960.jpg",
"https://image.made-in-china.com/43f34j00ZdUEHVynwvbO/Wax-Print-Ankara-African-Clothes-Women-Long-Maxi-Skirts.jpg",
"https://m.media-amazon.com/images/I/71CFgkweSKL._SR500,500_.jpg","https://www.fabindia.com/ccstore/v1/images/?source=/file/v2015230467035181626/products/10643899WH.f.180520.jpg&height=475&width=475"];

  constructor() { }

  ngOnInit() {
  }

  appear(category:string,state:string){

   this.display=category;
   this.state1=state;

   if(category=="dine"){
    this.state2="fade-right";
   }else if(category=="cloth"){
     this.state2=null;
   }
   
   }
    
   animate(e:Event){
     
    if(this.state1=="fade-up"){
      this.state2=null;
    }
   }
}