function varargout = GUI(varargin)
% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @GUI_OpeningFcn, ...
                   'gui_OutputFcn',  @GUI_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before GUI is made visible.
function GUI_OpeningFcn(hObject, eventdata, handles, varargin)

% Choose default command line output for GUI
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes GUI wait for user response (see UIRESUME)
% uiwait(handles.GUIGrafica);
%------------ configuracion del Puerto -------------------
% clc
% % close all
% clear all
% ar = arduino('COM3'); %inicializar comunicacion con arduino
%------------ configuracion de la tabla -------------------
title('Comunicacion Serial');
xlabel('Tiempo (t)');
ylabel('Voltaje (v)');
grid on; %poner lineas en la tabla
% hold on;

% --- Outputs from this function are returned to the command line.
function varargout = GUI_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in togglebutton1.
function togglebutton1_Callback(hObject, eventdata, handles)
% hObject    handle to togglebutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of togglebutton1



function txtAutor_Callback(hObject, eventdata, handles)
% hObject    handle to txtAutor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtAutor as text
%        str2double(get(hObject,'String')) returns contents of txtAutor as a double


% --- Executes during object creation, after setting all properties.
function txtAutor_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtAutor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in btnInciar.
function btnInciar_Callback(hObject, eventdata, handles)
%---------declaracion de variables-------------------------
separador = ',';
autor=get(handles.txtAutor,'String');
nombreArchivo = get(handles.txtNombreArchivo,'String');
capturas = get(handles.txtCapturas,'String');
%convertir la cadena de capturas en numero
num_capturas = str2num(capturas);
contador_capturas =1;
%obtener el valor del popup
contenidoPopUp = get(handles.popupLuces,'String');
popUpValor = contenidoPopUp{get(handles.popupLuces,'Value')};
%-----------validacion de campos para evitar vacios-----------------
if isempty(autor)
    warndlg('Ingresar nombre de quien realiza la prueba','Error')
    %fprintf('Error, completa el campo autor\n');
elseif isempty(nombreArchivo)
    warndlg('Ingrese un nombre para el archivo','Error')
elseif isempty(capturas)
    warndlg('No deje el campo vacio','Error')
else %fprintf(strcat(autor,nombreArchivo,capturas));   
%----------nombre_compuesto:guarda el nombre final del archivo-------------
   nombre_compuesto = strcat(autor,nombreArchivo,capturas,popUpValor);
%----------------- funcion principal -------------------------------------%
ar = arduino('COM4'); %inicializar comunicacion con arduino
Fs = 50; %frecuencia para la toma de muestras
N = num_capturas; %tamaño del vector segun numero de capturas
%------------------------- vectores de los 16 voltajes---------------------
V1 = zeros(N,1); %vector del V1 Nfilas 1Columna
V2 = zeros(N,1); %vector del V1 Nfilas 1Columna
V3 = zeros(N,1); %vector del V1 Nfilas 1Columna
V4 = zeros(N,1); %vector del V1 Nfilas 1Columna
V5 = zeros(N,1); %vector del V1 Nfilas 1Columna
V6 = zeros(N,1); %vector del V1 Nfilas 1Columna
V7 = zeros(N,1); %vector del V1 Nfilas 1Columna
V8 = zeros(N,1); %vector del V1 Nfilas 1Columna
V9 = zeros(N,1); %vector del V1 Nfilas 1Columna
V10= zeros(N,1); %vector del V1 Nfilas 1Columna
V11= zeros(N,1); %vector del V1 Nfilas 1Columna
V12= zeros(N,1); %vector del V1 Nfilas 1Columna
V13= zeros(N,1); %vector del V1 Nfilas 1Columna
V14= zeros(N,1); %vector del V1 Nfilas 1Columna
V15= zeros(N,1); %vector del V1 Nfilas 1Columna
V16= zeros(N,1); %vector del V1 Nfilas 1Columna
%-------------------------- finaliza vectores voltajes --------------------
t = linspace(0,(N-1)/Fs,N); %vector de tiempo
%------------------------diseño de las lineas------------------------------
A0 = line(nan,nan,'Color',[0 1.0000 0.8039],'LineWidth',2);
A1 = line(nan,nan,'Color',[0.3725 0.8667 0.6157],'LineWidth',2);
A2 = line(nan,nan,'Color',[0.2231 0.5373 0.5373],'LineWidth',2);
A3 = line(nan,nan,'Color',[0.0039 0.0863 0.1519],'LineWidth',2);
A4 = line(nan,nan,'Color',[0.3020 0.6157 0.8782],'LineWidth',2);
A5 = line(nan,nan,'Color',[0.7686 0.1176 0.2392],'LineWidth',2);
A6 = line(nan,nan,'Color',[1.0000 0.1725 0.3333],'LineWidth',2);
A7 = line(nan,nan,'Color',[0.9176 0.3216 0.2353],'LineWidth',2);
A8 = line(nan,nan,'Color',[0.9255 0.3212 0.2000],'LineWidth',2);
A9 = line(nan,nan,'Color',[0.9373 0.2782 0.2353],'LineWidth',2);
A10 = line(nan,nan,'Color',[1.0000 0.9212 0.3529],'LineWidth',2);
A11 = line(nan,nan,'Color',[0.9608 0.7216 0.1802],'LineWidth',2);
A12 = line(nan,nan,'Color',[0.9569 0.3765 0.2118],'LineWidth',2);
A13 = line(nan,nan,'Color',[0.9529 0.2588 0.1686],'LineWidth',2);
A14 = line(nan,nan,'Color',[0.8392 0.1569 0.1569],'LineWidth',2);
A15 = line(nan,nan,'Color',[0.2078 0.2078 0.1922],'LineWidth',2);
%------------------------fin del diseño de las lineas----------------------
%axis([0 num_capturas 0 5.1])
ylim([-.1 5.1])   %limite del voltaje
%xlim([0 t])
% xlim([0 (N-1)/Fs]) %limite dinamico 
%---------------------------graficar las señales---------------------------
tic
while contador_capturas < num_capturas
    if toc > 1/Fs
        tic
        
        V1(contador_capturas)= ar.analogRead(0)*5/1023; 
        V2(contador_capturas)= ar.analogRead(1)*5/1023;
        V3(contador_capturas)= ar.analogRead(2)*5/1023;
        V4(contador_capturas)= ar.analogRead(3)*5/1023;
        V5(contador_capturas)= ar.analogRead(4)*5/1023;
        V6(contador_capturas)= ar.analogRead(5)*5/1023;
        V7(contador_capturas)= ar.analogRead(6)*5/1023;
        V8(contador_capturas)= ar.analogRead(7)*5/1023;
        V9(contador_capturas)= ar.analogRead(8)*5/1023;
        V10(contador_capturas)= ar.analogRead(9)*5/1023;
        V11(contador_capturas)= ar.analogRead(10)*5/1023;
        V12(contador_capturas)= ar.analogRead(11)*5/1023;
        V13(contador_capturas)= ar.analogRead(12)*5/1023;
        V14(contador_capturas)= ar.analogRead(13)*5/1023;
        V15(contador_capturas)= ar.analogRead(14)*5/1023;
        V16(contador_capturas)= ar.analogRead(15)*5/1023;
       % y(1:end-1) = y(2:end); %estudiar esta linea
        %y(end) = ar.analogRead(0)*5/1023;
        %graficar el dato
        set(A0,'XData',t,'Ydata',V1)
        set(A1,'XData',t,'Ydata',V2)
        set(A2,'XData',t,'Ydata',V3)
        set(A3,'XData',t,'Ydata',V4)
        set(A4,'XData',t,'Ydata',V5)
        set(A5,'XData',t,'Ydata',V6)
        set(A6,'XData',t,'Ydata',V7)
        set(A7,'XData',t,'Ydata',V8)
        set(A8,'XData',t,'Ydata',V9)
        set(A9,'XData',t,'Ydata',V10)
        set(A10,'XData',t,'Ydata',V11)
        set(A11,'XData',t,'Ydata',V12)
        set(A12,'XData',t,'Ydata',V13)
        set(A13,'XData',t,'Ydata',V14)
        set(A14,'XData',t,'Ydata',V15)
        set(A15,'XData',t,'Ydata',V16)
        drawnow %grafica y se actualiza
        contador_capturas = contador_capturas+1;
    end %if
   
end %while
%-----------------Salida de los datos graficados   -----------------------%
%Voltajes = [V1',V2',V3',V4',V5',V6',V7',V8',V9',V10',V11',V12',V13',V14',V15',V16';t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t]; %agregar los otros 15 voltajes
Voltajes = [t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t;V1',V2',V3',V4',V5',V6',V7',V8',V9',V10',V11',V12',V13',V14',V15',V16'];
dlmwrite(strcat(nombre_compuesto,'.txt'),Voltajes'); %se guardan los voltajes y tiempo
%save('prueba.mat');
%*temporalmente se esta escibiendo lo que hay en la variable compuesto
clear all;
delete(instrfind({'Port'},{'COM4'}));
end


% --- Executes on button press in btnSalir.
function btnLimpiar_Callback(hObject, eventdata, handles)
%------------- limpiar los campos para realizar otra prueba--------------
set(handles.txtAutor,'String','');
set(handles.txtNombreArchivo,'String','');
set(handles.txtCapturas,'String','');
cla


% --- Executes on button press in btnSalir.
function btnSalir_Callback(hObject, eventdata, handles)
%boton para salir de la ventana de aplicacion
close(gcbf);



function txtNombreArchivo_Callback(hObject, eventdata, handles)
% hObject    handle to txtNombreArchivo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtNombreArchivo as text
%        str2double(get(hObject,'String')) returns contents of txtNombreArchivo as a double


% --- Executes during object creation, after setting all properties.
function txtNombreArchivo_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtNombreArchivo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function txtCapturas_Callback(hObject, eventdata, handles)
% hObject    handle to txtCapturas (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtCapturas as text
%        str2double(get(hObject,'String')) returns contents of txtCapturas as a double


% --- Executes during object creation, after setting all properties.
function txtCapturas_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtCapturas (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in btnProbarMotor.
function btnProbarMotor_Callback(hObject, eventdata, handles)
% hObject    handle to btnProbarMotor (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on selection change in popupLuces.
function popupLuces_Callback(hObject, eventdata, handles)
% hObject    handle to popupLuces (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns popupLuces contents as cell array
%        contents{get(hObject,'Value')} returns selected item from popupLuces


% --- Executes during object creation, after setting all properties.
function popupLuces_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupLuces (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in btnEncendido.
function btnEncendido_Callback(hObject, eventdata, handles)
% hObject    handle to btnEncendido (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in btnApagado.
function btnApagado_Callback(hObject, eventdata, handles)
% hObject    handle to btnApagado (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes when user attempts to close GUIGrafica.
function GUIGrafica_CloseRequestFcn(hObject, eventdata, handles)
% hObject    handle to GUIGrafica (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
opcion = questdlg('¿Desea salir del programa?','Salir','SI','NO','NO');
if strcmp(opcion,'NO')
    return;
end
% Hint: delete(hObject) closes the figure
delete(hObject);


% --- Executes during object creation, after setting all properties.
function axesVoltajesTiempo_CreateFcn(hObject, eventdata, handles)
% Hint: place code in OpeningFcn to populate axesVoltajesTiempo
