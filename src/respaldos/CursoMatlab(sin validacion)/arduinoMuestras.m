function arduinoMuestras(numero_muestras)
close all;
clc;
%vector con una fila y 1000 registros que ceran ceros
y = zeros(1,1000);

delete(instrfind({'Port'},{'COM3'}));
puerto_serial = serial('COM3');
puerto_serial.BaudRate = 9600;
warning('off','MATLAB:serial:fscanf:unsuccessfulRead');

fopen(puerto_serial);

contador_muestras = 1;

figure('Name','serial comunicacion con arduino')
title('titulo figura');
xlabel('Numero Muestras');
ylabel('Voltaje (v)');
grid on;
hold on;

while contador_muestras<=numero_muestras
        ylim([0 5.1]);
        xlim([contador_muestras-20 contador_muestras+5]);
        valor_potenciometro = fscanf(puerto_serial,'%d');
        %multiplica el vector de 1000 registros por la cantidad de muestras
        y(contador_muestras) = (valor_potenciometro(1))*5/1024;
        plot(contador_muestras,y(contador_muestras),'X-r');
        drawnow
        contador_muestras=contador_muestras+1;
end        
        fclose(puerto_serial);
        delete(puerto_serial);
        clear all;


end


















