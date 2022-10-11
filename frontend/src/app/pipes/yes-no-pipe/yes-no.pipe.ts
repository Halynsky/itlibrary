import { ModuleWithProviders, NgModule, Pipe, PipeTransform } from '@angular/core';


@Pipe({ name: 'yesNo'})
export class YesNoPipe implements PipeTransform {
  transform(value?: boolean, uppercase: boolean = false): any {
    let result = value ? 'Yes' : 'No';
    return uppercase ? result.toUpperCase() : result;
  }
}

@NgModule({
  declarations: [YesNoPipe],
  exports: [YesNoPipe],
})
export class YesNoPipeModule {
  static forRoot(): ModuleWithProviders<YesNoPipeModule> {
    return {
      ngModule: YesNoPipeModule,
      providers: [YesNoPipe]
    }
  }
}
