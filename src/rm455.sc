;;; Sierra Script 1.0 - (do not remove this comment)
(script# 455)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm455 0
)

(instance rm455 of LBRoom
	(properties
		picture 555
	)
	
	(method (init)
		(proc958_0 128 470 563)
		(proc958_0 132 6)
		(super init:)
		(gGame points: 1 134)
		(self setScript: sFindPippin)
	)
	
	(method (dispose)
		(screamAndLook fade: 0 12 30 1)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (newRoom newRoomNumber)
		(proc0_8 0)
		(screamAndLook fade: 0 12 30 1)
		(wrapMusic dispose: 1)
		(super newRoom: newRoomNumber)
	)
)

(instance sFindPippin of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 number: 82 flags: 1 loop: 1 play:)
				(wrapMusic init: -1 1 6)
				(= seconds 3)
			)
			(1
				(gGame handsOn:)
				(proc0_8 1)
				(global2 drawPic: 470)
				(global2 picture: 470)
				(drip init: setCycle: Fwd)
				(pipMummy init: setOnMeCheck: 1 -32768)
				(leftEye init: setOnMeCheck: 1 2)
				(rightEye init: setOnMeCheck: 1 4)
				(nose init: setOnMeCheck: 1 8)
				(moustache init: setOnMeCheck: 1 16)
				(mouthOpen init: setOnMeCheck: 1 32)
				(ear init: setOnMeCheck: 1 64)
				(hair init: setOnMeCheck: 1 128)
				(dagger init: setOnMeCheck: 1 256)
				(jacket init: setOnMeCheck: 1 512)
				(pants init: setOnMeCheck: 1 1024)
				(vest init: setOnMeCheck: 1 2048)
				(flesh init: setOnMeCheck: 1 4096)
				(shirt init: setOnMeCheck: 1 8192)
				(flower init: setOnMeCheck: 1 16384)
			)
			(2 (global2 newRoom: 454))
		)
	)
)

(instance drip of Prop
	(properties
		x 180
		y 100
		noun 2
		view 470
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pipMummy of Feature
	(properties
		x 1
		y 1
		noun 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance leftEye of Feature
	(properties
		x 1
		y 1
		noun 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rightEye of Feature
	(properties
		x 1
		y 1
		noun 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance nose of Feature
	(properties
		x 1
		y 1
		noun 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance moustache of Feature
	(properties
		x 1
		y 1
		noun 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance mouthOpen of Feature
	(properties
		x 1
		y 1
		noun 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance ear of Feature
	(properties
		x 1
		y 1
		noun 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance hair of Feature
	(properties
		x 1
		y 1
		noun 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance dagger of Feature
	(properties
		x 1
		y 1
		noun 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance jacket of Feature
	(properties
		x 1
		y 1
		noun 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (gEgo has: 21)
					(gLb2Messager say: 7 1 2)
				else
					(gLb2Messager say: 7 1 1)
				)
			)
			(8
				(if (gEgo has: 21)
					(gLb2Messager say: 7 8 2)
				else
					(gLb2Messager say: 7 8 1)
				)
			)
			(4
				(if (gEgo has: 21)
					(gLb2Messager say: 7 4 2)
				else
					(global2 setInset: inNotepad)
				)
			)
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pants of Feature
	(properties
		x 1
		y 1
		noun 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance vest of Feature
	(properties
		x 1
		y 1
		noun 16
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance flesh of Feature
	(properties
		x 1
		y 1
		noun 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance shirt of Feature
	(properties
		x 1
		y 1
		noun 15
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance flower of Feature
	(properties
		x 1
		y 1
		noun 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(13 (sFindPippin cue:))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance inNotepad of Inset
	(properties
		view 563
		loop 2
		cel 2
		x 118
		y 79
		disposeNotOnMe 1
	)
	
	(method (init)
		(super init: &rest)
		(gLb2Messager say: 7 4 1)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(self dispose:)
				(gGame points: 1 135)
				((ScriptID 21 0) doit: 790)
				(gEgo get: 21)
			)
			(1
				(gLb2Messager say: 45 1 0 0 0 15)
			)
			(8
				(gLb2Messager say: 45 8 0 0 0 15)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)
	
	(method (init)
		(= wrapSound screamAndLook)
		(super init: &rest)
	)
)

(instance screamAndLook of Sound
	(properties)
)
