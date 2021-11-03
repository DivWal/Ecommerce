import { Component, OnInit,ViewEncapsulation } from '@angular/core';
import { Product } from '../product'
import { ProductService } from '../product.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.productService.getProductList().subscribe(data => {
      this.products = data;
    });
  }

  updateProduct(id: string){
    this.router.navigate(['update-products', id]);
  }

  deleteProduct(id: string){
    this.productService.deleteProduct(id).subscribe( data => {
      console.log(data);
      this.getProducts();
    })
  }
}
