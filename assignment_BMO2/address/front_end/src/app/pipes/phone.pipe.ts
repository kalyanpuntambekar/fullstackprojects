import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneFormat'
})
export class PhoneFormatPipe implements PipeTransform {

  transform(number) {
    if (!number) { return ''; }

    var value = number.toString().trim().replace(/^\+/, '');
    console.log('Value ', value);
    if (value.match(/[^0-9\-]/)) return number;
    console.log('After ', value);

    let three = number.slice(0, 3);
    let six = number.slice(3);
    six = six.replace("-","");

    if (six) {

      if (six.length > 2) six = six.slice(0, 2) + '-' + six.slice(2, 6);
      console.log(six);


      return (three + "-" + six).trim();

    } else return three;
  }

}