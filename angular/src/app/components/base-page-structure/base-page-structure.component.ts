import { Component, Input, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-base-page-structure',
  imports: [],
  templateUrl: './base-page-structure.component.html',
  styleUrl: './base-page-structure.component.css'
})
export class BasePageStructureComponent {
  @Input() content!: TemplateRef<any>;
}
