export interface LoginResponse{
  jwtToken: string;
  usuario: {
      email: string;
      id: number;
      nome: string;
      senha: string;
      tipoCurso: string;
      tipoUsuario: string;
      username: string;

  }
}

