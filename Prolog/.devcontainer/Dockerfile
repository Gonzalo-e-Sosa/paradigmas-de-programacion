# Usa la imagen oficial de SWI-Prolog
FROM swipl:latest

# Carpeta de trabajo
WORKDIR /workspace

# Herramientas básicas
RUN apt-get update && \
    apt-get install -y git curl nano tree && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

    # Crear usuario vscode para desarrollo
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID
RUN groupadd --gid $USER_GID $USERNAME && \
    useradd --uid $USER_UID --gid $USER_GID -m $USERNAME && \
    chown -R $USERNAME:$USERNAME /workspace

USER $USERNAME



