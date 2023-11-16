class Aluno extends Usuario implements Usuario {
    private String curso;
    private String matricula;
    private boolean status; // (true para ativo;false para inativo)
    private boolean[] presencas = new boolean[20];
    private double[] notas = new double[3];

    public Aluno(String curso, String matricula, boolean status, boolean[] presencas, double[] notas) {
        this.curso = curso;
        this.matricula = matricula;
        this.status = status;
        this.presencas = presencas;
        this.notas = notas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean[] getPresencas() {
        return presencas;
    }

    public void setPresencas(boolean[] presencas) {
        this.presencas = presencas;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double media() {
        int faltas = 0;
        for (boolean presenca : presencas) {
            if (!presenca) {
                faltas++;
            }
        }

        if (faltas > 5) {
            System.out.println("Reprovado por falta");
            return -1;
        }

        int notasPendentes = 0;
        for (double nota : notas) {
            if (nota == 0.0) {
                notasPendentes++;
            }
        }

        if (notasPendentes > 0) {
            System.out.println("O aluno está com nota pendente");
            return -1;
        }

        double media = (notas[0] + notas[1] + notas[2]) / 3.0;
        if (media >= 7) {
            System.out.println("Aprovado por média");
        } else if (media >= 5 && media < 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }

        return media;
    }

    @Override
    public void verificarPresenca() {
        int faltas = 0;
        int presencas = 0;
        for (boolean presenca : this.presencas) {
            if (presenca) {
                presencas++;
            } else {
                faltas++;
            }
        }

        System.out.println("Faltas: " + faltas);
        System.out.println("Presenças: " + presencas);
    }

    @Override
    void atividade() {
        System.out.println("Está assistindo aula");
    }
}
