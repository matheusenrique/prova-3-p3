class Professor extends Usuario implements IOperacoes {
    private String curso;
    private String matricula;
    private Aluno[] turma = new Aluno[10];

    public Professor(String curso, String matricula, Aluno[] turma) {
        this.curso = curso;
        this.matricula = matricula;
        this.turma = turma;
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

    public Aluno[] getTurma() {
        return turma;
    }

    public void setTurma(Aluno[] turma) {
        this.turma = turma;
    }

    public double media() {
        double mediaTurma = 0;
        int count = 0;

        for (Aluno aluno : turma) {
            if (aluno != null) {
                double mediaAluno = aluno.media();
                if (mediaAluno != -1) {
                    mediaTurma += mediaAluno;
                    count++;
                }
            }
        }

        if (count > 0) {
            return mediaTurma / count;
        } else {
            throw new RuntimeException("Sem notas nessa turma.");
        }
    }

    @Override
    public void verificarPresenca() {
        for (Aluno aluno : turma) {
            if (aluno != null) {
                aluno.verificarPresenca();
            }
        }

    public void atividade() {
        System.out.println("Está dando aula para: ");
        for (Aluno aluno : turma) {
            if (aluno != null) {
                System.out.println(aluno.nome);
            }
        }
    }

}
