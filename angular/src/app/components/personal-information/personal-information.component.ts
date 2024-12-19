import { Component,Input,isStandalone,ViewEncapsulation } from '@angular/core';
import { Character } from '../../models/character.model';
import {CountriesAPIService} from '../../service/api/countries-api.service'
import { CommonModule } from '@angular/common';
import { Country } from '../../models/country.model';
import { FormsModule } from '@angular/forms';


@Component({
    selector: 'app-personal-information',
    imports: [CommonModule, FormsModule],
    templateUrl: './personal-information.component.html',
    styleUrl: './personal-information.component.css',
    encapsulation: ViewEncapsulation.Emulated,
    standalone:true
})
export class PersonalInformationComponent {
  constructor(private apiService: CountriesAPIService) {}
  @Input({required:true}) character!:Character;
  countries:Country[]=[];
  selectedCountry:Country=new Country("","","","");
  ngOnInit():void{
    this.apiService.getCountriesInLanguage("fra").subscribe((item)=>this.countries=item)
    this.countries.sort((a,b)=> a.name.localeCompare((b.name)));
  }
  
}
