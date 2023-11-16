class Coordenador extends Professor {
    private String horaDeAtendimento;

    public Coordenador(String curso, String matricula, Aluno[] turma, String horaDeAtendimento) {
        super(curso, matricula, turma);
        this.horaDeAtendimento = horaDeAtendimento;
    }

    public String getHoraDeAtendimento() {
        return horaDeAtendimento;
    }

    public void setHoraDeAtendimento(String horaDeAtendimento) {
        this.horaDeAtendimento = horaDeAtendimento;
    }

    void solicitacaoAluno(Aluno aluno) {
        if (aluno.status) {
            aluno.status = false;
        } else {
            aluno.status = true;
        }
    }

    void removerTurma(Aluno aluno, Professor professor) {
        boolean alunoRemovido = false;
        for (int i = 0; i < professor.turma.length; i++) {
            if (professor.turma[i] == aluno) {
                professor.turma[i] = null;
                alunoRemovido = true;
                break;
            }
        }

        if (!alunoRemovido) {
            throw new RuntimeException("O aluno não está presente.");
        }
    }

}
