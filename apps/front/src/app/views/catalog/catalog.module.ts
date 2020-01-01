// Angular
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CategoriesComponent } from './categories.component';
import { ProductsComponent } from './products.component';

// Catalog Routing
import { CatalogRoutingModule } from './catalog-routing.module';

@NgModule({
  imports: [
    CommonModule,
    CatalogRoutingModule
  ],
  declarations: [
    CategoriesComponent,
    ProductsComponent
  ]
})
export class CatalogModule { }
