import { Component, Input, forwardRef } from '@angular/core';
import { ControlValueAccessor, FormControl, NG_VALUE_ACCESSOR, ReactiveFormsModule } from '@angular/forms';

type InputTypes = "text" | "email"| "password";

@Component({
  selector: 'app-basic-input',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './basic-input.component.html',
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => BasicInputComponent),
      multi: true
    }
  ]
})
export class BasicInputComponent implements ControlValueAccessor {
  @Input() controlName: string = '';
  @Input() type: InputTypes = 'text';
  @Input() placeholder: string = '';
  @Input() maxlength?: number;
  @Input() control!: FormControl;

  value: string = '';
  onChange: (value: string) => void = () => {};
  onTouched: () => void = () => {};

  writeValue(value: string): void {
    if (value !== undefined) {
      this.value = value;
    }
  }

  registerOnChange(fn: (value: string) => void): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: () => void): void {
    this.onTouched = fn;
  }

  handleChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.value = input.value;
    this.onChange(this.value);
  }

  handleBlur(): void {
    this.onTouched();
  }
}
