import { ModuleWithProviders } from '@angular/core';
import { Routes } from '@angular/router';

export interface IEmployee {
  id: number;
  firstName: string;
  lastName: string;
  role: string;
}

export interface IPartner {
  id: number;
  name: string;
  description: string;
  email: string;
}
