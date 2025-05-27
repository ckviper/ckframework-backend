FROM python:3.10-slim

# Установка системных зависимостей
RUN apt-get update && apt-get install -y --no-install-recommends \
    build-essential \
    git \
    && rm -rf /var/lib/apt/lists/*

# Установка Python-пакетов
RUN pip install --upgrade pip && \
    pip install torch torchvision torchaudio --index-url https://download.pytorch.org/whl/cpu && \
    pip install vllm transformers huggingface-hub

# Предзагрузка моделей (опционально)
RUN python3 -c "from transformers import AutoModelForCausalLM; AutoModelForCausalLM.from_pretrained('gpt2', cache_dir='/models')"

WORKDIR /app
EXPOSE 8000

CMD ["python", "-m", "vllm.entrypoints.openai.api_server", \
     "--model", "gpt2", \
     "--port", "8000", \
     "--device", "cpu", \
     "--enforce-eager"]  # Режим для CPU